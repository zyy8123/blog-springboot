package com.zyy.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyy.blog.dto.ResourceDTO;
import com.zyy.blog.dto.LabelOptionDTO;
import com.zyy.blog.entity.Resource;
import com.zyy.blog.vo.ConditionVO;
import com.zyy.blog.vo.ResourceVO;

import java.util.List;


/**
 * 资源服务
 *
 * @author poixao
 * @date 2022/11/01
 */
public interface ResourceService extends IService<Resource> {

    /**
     * 添加或修改资源
     *
     * @param resourceVO 资源对象
     */
    void saveOrUpdateResource(ResourceVO resourceVO);

    /***
     * 删除资源
     *
     @param resourceId 资源id
     */
    void deleteResource(Integer resourceId);

    /**
     * 查看资源列表
     *
     * @param conditionVO 条件
     * @return 资源列表
     */
    List<ResourceDTO> listResources(ConditionVO conditionVO);

    /**
     * 查看资源选项
     *
     * @return 资源选项
     */
    List<LabelOptionDTO> listResourceOption();

}
