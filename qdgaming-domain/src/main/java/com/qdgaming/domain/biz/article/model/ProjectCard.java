package com.qdgaming.domain.biz.article.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/3 20:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectCard {
    private String projectName;
    private String projectRepositoryUrl;
    private String author;
    private String authorHomePageUrl;
    private String description;
    private String codeType;
    private String star;
}
