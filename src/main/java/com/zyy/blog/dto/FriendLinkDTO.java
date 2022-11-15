package com.zyy.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 友情链接
 *
 * @author poixao
 * @date 2022/11/01
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FriendLinkDTO {

    /**
     * id
     */
    private Integer id;

    /**
     * 链接名
     */
    private String linkName;

    /**
     * 链接头像
     */
    private String linkAvatar;

    /**
     * 链接地址
     */
    private String linkAddress;

    /**
     * 介绍
     */
    private String linkIntro;

}
