package com.zyy.blog.strategy;

import com.zyy.blog.dto.ArticleSearchDTO;

import java.util.List;

/**
 * 搜索策略
 *
 * @author poixao
 * @date 2022/11/01
 */
public interface SearchStrategy {

    /**
     * 搜索文章
     *
     * @param keywords 关键字
     * @return {@link List<ArticleSearchDTO>} 文章列表
     */
    List<ArticleSearchDTO> searchArticle(String keywords);

}
