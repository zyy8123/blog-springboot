package com.zyy.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * hexo文章
 *
 * @author poixao
 * @date 2022/11/01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HexoArticleVO extends ArticleVO {
    private LocalDateTime createTime;
}
