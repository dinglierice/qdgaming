package com.qdgaming.domain.biz.user.repository;

import com.qdgaming.domain.biz.user.model.UserModel;

public interface UserRepository {
    UserModel queryById(long id);
    UserModel queryByUsername(String username);
    UserModel insert(UserModel readerModel);
}
