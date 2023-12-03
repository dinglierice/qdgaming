package com.qdgaming.domain.biz.article.service;

import com.google.common.collect.HashBasedTable;
import com.qdgaming.domain.biz.article.enums.Action;
import com.qdgaming.domain.biz.article.enums.App;
import com.qdgaming.domain.biz.article.repository.ArticleRepository;
import com.qdgaming.domain.biz.article.service.crwaler.AbstractCrawler;
import com.qdgaming.domain.biz.article.service.crwaler.GithubArticleCrawlerTask;
import com.qdgaming.utility.exception.UtilException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/2 12:45
 */
@Service
public class ArticleService {
    private final ExecutorService producerService = Executors.newSingleThreadExecutor();
    private final ScheduledExecutorService consumerService = Executors.newScheduledThreadPool(1);
    private final BlockingQueue<AbstractCrawler> queue = new LinkedBlockingQueue<>();
    private static final HashBasedTable<App, Action, AbstractCrawler> crawlerTable = HashBasedTable.create();

    static {
        crawlerTable.put(App.GITHUB_ZH, Action.PC_WEB, new GithubArticleCrawlerTask());
    }

    @Resource
    ArticleRepository articleRepository;

    /**
     * 目前只支持无参调度，按照次数、qps、调度器去配置，一切从简，这不是重点
     * @param requestTime
     * @param qps
     * @param appStr
     * @param actionStr
     */
    public void generateArticleByScheduleWithFixedUrl(int requestTime, int qps, String appStr, String actionStr) {
        App app = App.getAppByCode(appStr);
        Action action = Action.getActionByCode(actionStr);
        AbstractCrawler abstractCrawler = crawlerTable.get(app, action);

        if (null == abstractCrawler) {
            throw new UtilException("没有为该APP和ACTION配置抓取器");
        }

        producerService.submit(() -> {
            for (int i = 0; i < requestTime; i++) {
                queue.add(abstractCrawler);
            }
        });

        consumeAndRun(qps);
    }


    // TODO 有参调度的设计
    public void generateArticleByScheduleWithFixedParams(List<Map<String, Object>> requestParams, int qps, String appStr, String actionStr) {

    }

    private void consumeAndRun(int qps) {
        Runnable consumerTask = () -> {
            try {
                Runnable crawlTask = queue.take();
                crawlTask.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        long period = TimeUnit.SECONDS.toMillis(1)/qps;
        consumerService.scheduleAtFixedRate(consumerTask, 0, period, TimeUnit.MILLISECONDS);
    }
}
