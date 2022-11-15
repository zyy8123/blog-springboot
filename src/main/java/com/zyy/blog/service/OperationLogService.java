package com.zyy.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyy.blog.dto.OperationLogDTO;
import com.zyy.blog.vo.PageResult;
import com.zyy.blog.entity.OperationLog;
import com.zyy.blog.vo.ConditionVO;

/**
 * 操作日志服务
 *
 * @author poixao
 * @date 2022/11/01
 */
public interface OperationLogService extends IService<OperationLog> {

    /**
     * 查询日志列表
     *
     * @param conditionVO 条件
     * @return 日志列表
     */
    PageResult<OperationLogDTO> listOperationLogs(ConditionVO conditionVO);

}
