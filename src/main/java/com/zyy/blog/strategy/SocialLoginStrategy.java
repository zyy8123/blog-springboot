package com.zyy.blog.strategy;

import com.zyy.blog.dto.UserInfoDTO;

/**
 * 第三方登录策略
 *
 * @author poixao
 * @date 2022/11/01
 */
public interface SocialLoginStrategy {

    /**
     * 登录
     *
     * @param data 数据
     * @return {@link UserInfoDTO} 用户信息
     */
    UserInfoDTO login(String data);

}
