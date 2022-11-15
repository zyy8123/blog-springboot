package com.zyy.blog.dao;

import com.zyy.blog.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;


/**
 * 留言
 *
 * @author poixao
 * @date 2022/11/01
 */
@Repository
public interface MessageDao extends BaseMapper<Message> {

}
