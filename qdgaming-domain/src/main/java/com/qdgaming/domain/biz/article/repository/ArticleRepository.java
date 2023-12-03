package com.qdgaming.domain.biz.article.repository;

import com.qdgaming.domain.biz.article.model.ArticleModel;

public interface ArticleRepository {
    ArticleModel saveArticle(ArticleModel articleModel);
}
