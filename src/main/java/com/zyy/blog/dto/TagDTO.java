package com.zyy.blog.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 标签
 *
 * @author poixao
 * @date 2022/11/01
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TagDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 标签名
     */
    private String tagName;

}
