package com.zyy.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyy.blog.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 菜单
 *
 * @author poixao
 * @date 2022/11/01
 */
@Repository
public interface MenuDao extends BaseMapper<Menu> {

    /**
     * 根据用户id查询菜单
     * @param userInfoId 用户信息id
     * @return 菜单列表
     */
    List<Menu> listMenusByUserInfoId(Integer userInfoId);

}
