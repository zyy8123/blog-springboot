package com.zyy.blog.dao;

import com.zyy.blog.dto.ArticleSearchDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


/**
 * elasticsearch
 *
 * @author poixao
 * @date 2022/11/01
 */
@Repository
public interface ElasticsearchDao extends ElasticsearchRepository<ArticleSearchDTO,Integer> {
}
