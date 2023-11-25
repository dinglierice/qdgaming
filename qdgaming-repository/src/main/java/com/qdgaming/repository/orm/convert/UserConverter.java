package com.qdgaming.repository.orm.convert;

import com.qdgaming.domain.biz.user.model.UserModel;
import com.qdgaming.repository.orm.user.UserDO;

/**
 * @description：类型转换
 * @author：dinglie
 * @date：2023/11/25 9:50
 */
public class UserConverter {
    public static UserModel convertUserDO2UserModel(UserDO userDO) {
        if (userDO == null) {
            return null;
        }

        return UserModel.builder()
                .id(userDO.getId())
                .createTime(userDO.getCreateTime())
                .updateTime(userDO.getUpdateTime())
                .userName(userDO.getUserName())
                .password(userDO.getPassword())
                .build();
    }

    public static UserDO convertUserModel2UserDO(UserModel userModel) {
        if (userModel == null) {
            return null;
        }

        UserDO userDO = UserDO.builder()
                .userName(userModel.getUserName())
                .password(userModel.getPassword())
                .build();

        userDO.setId(userModel.getId());
        userDO.setCreateTime(userModel.getCreateTime());
        userDO.setUpdateTime(userModel.getUpdateTime());

        return userDO;

    }
}
