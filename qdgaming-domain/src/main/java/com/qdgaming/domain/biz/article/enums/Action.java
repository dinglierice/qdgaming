package com.qdgaming.domain.biz.article.enums;


public enum Action {
    PC_WEB("PC_WEB");

    private String code;

    public String getCode() {
        return this.code;
    }
    Action(String code) {
        this.code = code;
    }

    public static Action getActionByCode(String code) {
        for (Action value : Action.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
