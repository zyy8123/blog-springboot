package com.zyy.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyy.blog.dao.OperationLogDao;
import com.zyy.blog.dto.OperationLogDTO;
import com.zyy.blog.util.PageUtils;
import com.zyy.blog.vo.ConditionVO;
import com.zyy.blog.vo.PageResult;
import com.zyy.blog.entity.OperationLog;
import com.zyy.blog.service.OperationLogService;
import com.zyy.blog.util.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作日志服务
 *
 * @author poixao
 * @date 2021/08/08
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogDao, OperationLog> implements OperationLogService {

    @Override
    public PageResult<OperationLogDTO> listOperationLogs(ConditionVO conditionVO) {
        Page<OperationLog> page = new Page<>(PageUtils.getCurrent(), PageUtils.getSize());
        // 查询日志列表
        Page<OperationLog> operationLogPage = this.page(page, new LambdaQueryWrapper<OperationLog>()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()), OperationLog::getOptModule, conditionVO.getKeywords())
                .or()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()), OperationLog::getOptDesc, conditionVO.getKeywords())
                .orderByDesc(OperationLog::getId));
        List<OperationLogDTO> operationLogDTOList = BeanCopyUtils.copyList(operationLogPage.getRecords(), OperationLogDTO.class);
        return new PageResult<>(operationLogDTOList, (int) operationLogPage.getTotal());
    }

}
