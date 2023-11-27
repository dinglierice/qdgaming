package com.qdgaming.repository.impl;

import com.qdgaming.domain.biz.user.model.UserModel;
import com.qdgaming.domain.biz.user.repository.UserRepository;
import com.qdgaming.repository.mapper.user.UserDOMapper;
import com.qdgaming.repository.orm.convert.UserConverter;
import com.qdgaming.repository.orm.user.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/11/25 19:18
 */
@Service
public class UserRepositoryImpl implements UserRepository {

    @Resource
    UserDOMapper userDOMapper;

    @Override
    public UserModel queryById(long id) {
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        return UserConverter.convertUserDO2UserModel(userDO);
    }

    @Override
    public UserModel queryByUsername(String username) {
        UserDO userDO = userDOMapper.selectByName(username);
        return UserConverter.convertUserDO2UserModel(userDO);
    }

    @Override
    @Transactional
    public UserModel insert(UserModel userModel) {
        UserDO userDO = UserConverter.convertUserModel2UserDO(userModel);
        int insert = userDOMapper.insert(userDO);
        if (insert > 0) {
            //查询一次。
            userDO = userDOMapper.selectByName(userDO.getUserName());
            return UserConverter.convertUserDO2UserModel(userDO);
        }
        return null;
    }

    @Override
    public List<UserModel> listHead(int row) {
        List<UserDO> userDOS = userDOMapper.selectHead(row);
        if (CollectionUtils.isEmpty(userDOS)) {
            return null;
        }
        return userDOS.stream().map(UserConverter::convertUserDO2UserModel).collect(Collectors.toList());
    }
}
