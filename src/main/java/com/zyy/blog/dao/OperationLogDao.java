package com.zyy.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyy.blog.entity.OperationLog;
import org.springframework.stereotype.Repository;


/**
 * 操作日志
 *
 * @author poixao
 * @date 2022/11/01
 */
@Repository
public interface OperationLogDao extends BaseMapper<OperationLog> {
}
