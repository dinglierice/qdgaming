package com.qdgaming.controller.biz.article;

import com.qdgaming.application.base.request.ArticleScheduleRequest;
import com.qdgaming.application.biz.article.ArticleScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/2 12:59
 */
@Api(tags = "ArticleController", description = "文章")
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Resource
    ArticleScheduleService articleScheduleService;

    @PostMapping("/start/crawl")
    @ApiOperation(value = "开启爬虫文章调度")
    public void startCrawl(@RequestBody ArticleScheduleRequest articleScheduleRequest) {
        articleScheduleService.startSchedule(articleScheduleRequest);
    }
}
