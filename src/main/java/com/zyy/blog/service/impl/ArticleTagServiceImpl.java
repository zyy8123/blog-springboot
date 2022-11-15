package com.zyy.blog.service.impl;

import com.zyy.blog.entity.ArticleTag;
import com.zyy.blog.dao.ArticleTagDao;
import com.zyy.blog.service.ArticleTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 文章标签服务
 *
 * @author poixao
 * @date 2022/11/01
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagDao, ArticleTag> implements ArticleTagService {

}
