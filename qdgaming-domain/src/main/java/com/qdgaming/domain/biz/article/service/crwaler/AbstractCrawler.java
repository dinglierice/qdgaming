package com.qdgaming.domain.biz.article.service.crwaler;

import com.qdgaming.domain.biz.article.repository.ArticleRepository;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/3 23:05
 */
@Component
public abstract class AbstractCrawler implements Runnable{
    private String baseUrl = null;

    @Getter
    @Setter
    private String finalUrl = null;

    @Resource
    ArticleRepository articleRepository;

    @Override
    public abstract void run();

    public void formFinalUrl(Map<String, Object> parameters) {
        if (null != baseUrl) {
            StringSubstitutor strSubstitutor = new StringSubstitutor(parameters);
            String replace = strSubstitutor.replace(baseUrl);
            setFinalUrl(replace);
        }
    }
}
