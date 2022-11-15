package com.zyy.blog.dao;

import com.zyy.blog.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;


/**
 * 用户信息
 *
 * @author poixao
 * @date 2022/11/01
 */
@Repository
public interface UserInfoDao extends BaseMapper<UserInfo> {

}
