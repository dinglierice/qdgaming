package com.qdgaming.domain.biz.article.service;

import com.qdgaming.domain.biz.article.repository.ArticleRepository;
import com.qdgaming.domain.biz.article.service.crwaler.ZhihuArticleCrawlerTask;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    @Resource
    ArticleRepository articleRepository;

    public void generateArticleBySchedule(int requestTime, int qps) {
        producerService.submit(() -> {
            for (int i = 0; i < requestTime; i++) {
                queue.add(new ZhihuArticleCrawlerTask("https://www.zhihu.com", articleRepository));
            }
        });

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
