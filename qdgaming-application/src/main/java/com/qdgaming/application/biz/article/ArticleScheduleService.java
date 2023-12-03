package com.qdgaming.application.biz.article;

import com.qdgaming.application.base.request.ArticleScheduleRequest;
import com.qdgaming.domain.biz.article.enums.App;
import com.qdgaming.domain.biz.article.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.RegEx;
import javax.annotation.Resource;

/**
 * @description：
 * @author：dinglie
 * @date：2023/12/2 12:51
 */
@Service
public class ArticleScheduleService {
    @Resource
    ArticleService articleService;

    public void startSchedule(ArticleScheduleRequest articleScheduleRequest) {
        articleService.generateArticleByScheduleWithFixedUrl(
                articleScheduleRequest.getRequestTime()
                , articleScheduleRequest.getQps()
                , articleScheduleRequest.getAppCode()
                , articleScheduleRequest.getActionCode());
    }
}
