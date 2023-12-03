package com.qdgaming.domain.biz.article.service.crwaler;

import com.qdgaming.domain.biz.article.enums.Action;
import com.qdgaming.domain.biz.article.enums.App;
import com.qdgaming.domain.biz.article.model.ArticleModel;
import com.qdgaming.domain.biz.article.repository.ArticleRepository;
import org.jsoup.Jsoup;

import java.util.Date;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/3 12:22
 */
public class ZhihuArticleCrawlerTask implements Runnable{
    private final String url;
    private final ArticleRepository articleRepository;

    public ZhihuArticleCrawlerTask(String url, ArticleRepository articleRepository) {
        this.url = url;
        this.articleRepository = articleRepository;
    }

    @Override
    public void run() {
        try {
            String html = Jsoup.connect(url).get().html();
            ArticleModel articleModel = ArticleModel.builder().
                    createTime(new Date()).
                    updateTime(new Date()).
                    action(Action.PC_WEB).
                    app(App.ZHIHU).
                    req(this.url).result(html).build();
            articleRepository.saveArticle(articleModel);
            System.out.println("Crawled: " + url);
        } catch (Exception e) {
            System.err.println("fail to crawl: " + url);
            e.printStackTrace();
        }
    }
}
