package com.zyy.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyy.blog.entity.ChatRecord;
import org.springframework.stereotype.Repository;

/**
 * 聊天记录
 *
 * @author poixao
 * @date 2022/11/01
 */
@Repository
public interface ChatRecordDao extends BaseMapper<ChatRecord> {
}
