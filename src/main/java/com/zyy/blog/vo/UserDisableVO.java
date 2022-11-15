package com.zyy.blog.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 用户禁用状态
 *
 * @author poixao
 * @date 2022/11/01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "用户禁用状态")
public class UserDisableVO {

    /**
     * id
     */
    @NotNull(message = "用户id不能为空")
    private Integer id;

    /**
     * 置顶状态
     */
    @NotNull(message = "置顶状态不能为空")
    private Integer isDisable;

}
