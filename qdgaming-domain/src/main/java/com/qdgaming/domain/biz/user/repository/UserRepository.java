package com.qdgaming.domain.biz.user.repository;

import com.qdgaming.domain.biz.user.model.UserModel;

import java.util.List;

public interface UserRepository {
    /**
     * 查找模型
     * @param id
     * @return
     */
    UserModel queryById(long id);

    /**
     * 姓名检索
     * @param username
     * @return
     */
    UserModel queryByUsername(String username);

    /**
     * 插入用户
     * @param readerModel
     * @return
     */
    UserModel insert(UserModel readerModel);

    /**
     * 查询用户列表
     * @return
     */
    List<UserModel> listHead(int row);
}
