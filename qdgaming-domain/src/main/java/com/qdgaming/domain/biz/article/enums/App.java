package com.qdgaming.domain.biz.article.enums;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/12/2 12:41
 */
public enum App {
    ZHIHU("ZHIHU"), GITHUB_ZH("GITHUB_ZH");
    private String code;

    App(String zhihu) {
    }

    public String getCode() {
        return this.code;
    }

    public static App getAppByCode(String code) {
        for (App value : App.values()) {
            if (code.equals(value.getCode())) {
                return value;
            }
        }
        return null;
    }
}
