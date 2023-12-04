package com.qdgaming.domain.biz.article.service.crwaler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/5 0:01
 */
public class GithubHomeArticleCrawlerTask extends AbstractCrawler{
    private String baseUrl = "https://www.github-zh.com/trending";

    @Override
    public void run() {
        try {
            Document document = Jsoup.connect(baseUrl).get();
            Elements scripts = document.select("script");
            List<String> result = new ArrayList<String>();
            for (Element script : scripts) {

            }
        } catch (IOException e) {
            System.err.println("fail to crawl: " + baseUrl);
            e.printStackTrace();
        }
    }
}
