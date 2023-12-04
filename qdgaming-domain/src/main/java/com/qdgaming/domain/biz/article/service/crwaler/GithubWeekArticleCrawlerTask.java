package com.qdgaming.domain.biz.article.service.crwaler;

import com.qdgaming.domain.biz.article.enums.Action;
import com.qdgaming.domain.biz.article.enums.App;
import com.qdgaming.domain.biz.article.model.ArticleModel;
import com.qdgaming.domain.biz.article.model.ProjectCard;
import com.qdgaming.domain.biz.article.repository.ArticleRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/3 12:22
 */
@Component
public class GithubWeekArticleCrawlerTask extends AbstractCrawler{
    private final String GITHUB_ZH_URL = "https://www.github-zh.com/trends/weekly";

    @Override
    public void run() {
        try {
            Document document = Jsoup.connect(GITHUB_ZH_URL).get();
            List<ProjectCard> result = new ArrayList<>();
            Elements elementsByClass = document.getElementsByClass("repo-card anim-hover-grow");
            for (Element element : elementsByClass) {
                String projectName = element.getElementsByClass("d-flex flex-column").text();
                String projectRepoUrl = element.getElementsByClass("text-bold color-fg-default").attr("href");
                String authorName = element.getElementsByClass("flex-none truncate").text();
                String authorHomePageUrl = element.getElementsByClass("color-fg-muted").attr("href");
                String description = element.getElementsByClass("body").select("p").select("span").html();
                String codeType = element.getElementsByClass("text-small mr-2 color-fg-subtle").text();
                String star = element.getElementsByClass("text-small mr-1 color-fg-subtle").text();
                ProjectCard projectCard = ProjectCard.builder().projectName(projectName)
                        .projectRepositoryUrl(projectRepoUrl)
                        .author(authorName)
                        .authorHomePageUrl(authorHomePageUrl)
                        .description(description)
                        .codeType(codeType)
                        .star(star).build();
                result.add(projectCard);
            }

            Map<String, Object> req = new HashMap<>();
            req.put("url", GITHUB_ZH_URL);

            ArticleModel articleModel = ArticleModel.builder()
                    .app(App.GITHUB_ZH)
                    .action(Action.PC_WEB)
                    .createTime(new Date())
                    .updateTime(new Date())
                    .req(req)
                    .result(result)
                    .build();
            articleRepository.saveArticle(articleModel);
        } catch (Exception e) {
            System.err.println("fail to crawl: " + GITHUB_ZH_URL);
            e.printStackTrace();
        }
    }
}
