package com.zyy.blog.strategy.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.zyy.blog.dao.UserAuthDao;
import com.zyy.blog.dao.UserInfoDao;
import com.zyy.blog.dao.UserRoleDao;
import com.zyy.blog.dto.SocialUserInfoDTO;
import com.zyy.blog.dto.SocialTokenDTO;
import com.zyy.blog.dto.UserDetailDTO;
import com.zyy.blog.dto.UserInfoDTO;
import com.zyy.blog.entity.UserAuth;
import com.zyy.blog.entity.UserInfo;
import com.zyy.blog.entity.UserRole;
import com.zyy.blog.enums.RoleEnum;
import com.zyy.blog.exception.BizException;
import com.zyy.blog.service.impl.UserDetailsServiceImpl;
import com.zyy.blog.strategy.SocialLoginStrategy;
import com.zyy.blog.util.BeanCopyUtils;
import com.zyy.blog.util.IpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

import static com.zyy.blog.constant.CommonConst.TRUE;
import static com.zyy.blog.enums.ZoneEnum.SHANGHAI;


/**
 * 第三方登录抽象模板
 *
 * @author poixao
 * @date 2022/11/01
 */
@Service
public abstract class AbstractSocialLoginStrategyImpl implements SocialLoginStrategy {
    @Autowired
    private UserAuthDao userAuthDao;
    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Resource
    private HttpServletRequest request;

    @Override
    public UserInfoDTO login(String data) {
        // 创建登录信息
        UserDetailDTO userDetailDTO;
        // 获取第三方token信息
        SocialTokenDTO socialToken = getSocialToken(data);
        // 获取用户ip信息
        String ipAddress = IpUtils.getIpAddress(request);
        String ipSource = IpUtils.getIpSource(ipAddress);
        // 判断是否已注册
        UserAuth user = getUserAuth(socialToken);
        if (Objects.nonNull(user)) {
            // 返回数据库用户信息
            userDetailDTO = getUserDetail(user, ipAddress, ipSource);
        } else {
            // 获取第三方用户信息，保存到数据库返回
            userDetailDTO = saveUserDetail(socialToken, ipAddress, ipSource);
        }
        // 判断账号是否禁用
        if (userDetailDTO.getIsDisable().equals(TRUE)) {
            throw new BizException("账号已被禁用");
        }
        // 将登录信息放入springSecurity管理
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetailDTO, null, userDetailDTO.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        // 返回用户信息
        return BeanCopyUtils.copyObject(userDetailDTO, UserInfoDTO.class);
    }

    /**
     * 获取第三方token信息
     *
     * @param data 数据
     * @return {@link SocialTokenDTO} 第三方token信息
     */
    public abstract SocialTokenDTO getSocialToken(String data);

    /**
     * 获取第三方用户信息
     *
     * @param socialTokenDTO 第三方token信息
     * @return {@link SocialUserInfoDTO} 第三方用户信息
     */
    public abstract SocialUserInfoDTO getSocialUserInfo(SocialTokenDTO socialTokenDTO);

    /**
     * 获取用户账号
     *
     * @return {@link UserAuth} 用户账号
     */
    private UserAuth getUserAuth(SocialTokenDTO socialTokenDTO) {
        return userAuthDao.selectOne(new LambdaQueryWrapper<UserAuth>()
                .eq(UserAuth::getUsername, socialTokenDTO.getOpenId())
                .eq(UserAuth::getLoginType, socialTokenDTO.getLoginType()));
    }

    /**
     * 获取用户信息
     *
     * @param user      用户账号
     * @param ipAddress ip地址
     * @param ipSource  ip源
     * @return {@link UserDetailDTO} 用户信息
     */
    private UserDetailDTO getUserDetail(UserAuth user, String ipAddress, String ipSource) {
        // 更新登录信息
        userAuthDao.update(new UserAuth(), new LambdaUpdateWrapper<UserAuth>()
                .set(UserAuth::getLastLoginTime, LocalDateTime.now())
                .set(UserAuth::getIpAddress, ipAddress)
                .set(UserAuth::getIpSource, ipSource)
                .eq(UserAuth::getId, user.getId()));
        // 封装信息
        return userDetailsService.convertUserDetail(user, request);
    }

    /**
     * 新增用户信息
     *
     * @param socialToken token信息
     * @param ipAddress   ip地址
     * @param ipSource    ip源
     * @return {@link UserDetailDTO} 用户信息
     */
    private UserDetailDTO saveUserDetail(SocialTokenDTO socialToken, String ipAddress, String ipSource) {
        // 获取第三方用户信息
        SocialUserInfoDTO socialUserInfo = getSocialUserInfo(socialToken);
        // 保存用户信息
        UserInfo userInfo = UserInfo.builder()
                .nickname(socialUserInfo.getNickname())
                .avatar(socialUserInfo.getAvatar())
                .build();
        userInfoDao.insert(userInfo);
        // 保存账号信息
        UserAuth userAuth = UserAuth.builder()
                .userInfoId(userInfo.getId())
                .username(socialToken.getOpenId())
                .password(socialToken.getAccessToken())
                .loginType(socialToken.getLoginType())
                .lastLoginTime(LocalDateTime.now(ZoneId.of(SHANGHAI.getZone())))
                .ipAddress(ipAddress)
                .ipSource(ipSource)
                .build();
        userAuthDao.insert(userAuth);
        // 绑定角色
        UserRole userRole = UserRole.builder()
                .userId(userInfo.getId())
                .roleId(RoleEnum.USER.getRoleId())
                .build();
        userRoleDao.insert(userRole);
        return userDetailsService.convertUserDetail(userAuth, request);
    }

}
