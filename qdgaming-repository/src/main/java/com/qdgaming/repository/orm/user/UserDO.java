package com.qdgaming.repository.orm.user;

import com.qdgaming.repository.orm.base.BaseEntityDO;
import lombok.Builder;

@Builder
public class UserDO extends BaseEntityDO {
    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}