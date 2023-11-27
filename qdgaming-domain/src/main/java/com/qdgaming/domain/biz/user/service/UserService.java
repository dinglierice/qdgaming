package com.qdgaming.domain.biz.user.service;

import com.qdgaming.domain.biz.user.model.UserModel;
import com.qdgaming.domain.biz.user.repository.UserRepository;
import com.qdgaming.utility.exception.UtilException;
import com.qdgaming.utility.util.CryptUtil;
import org.apache.commons.codec.digest.Crypt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Resource
    UserRepository userRepository;

    public UserModel register(String userName, String password) {
        UserModel userModel = userRepository.queryByUsername(userName);
        if (userModel != null) {
            throw new UtilException("当前用户已存在");
        }

        String encodedPassword = CryptUtil.bCryptEncode(password);
        userModel = UserModel
                .builder()
                .createTime(new Date())
                .updateTime(new Date())
                .userName(userName)
                .password(encodedPassword)
                .build();
        userModel = userRepository.insert(userModel);
        return userModel;
    }

    public UserModel login(String userName, String password) {
        UserModel userModel = userRepository.queryByUsername(userName);
        if (null == userModel) {
            throw new UtilException("用户不存在");
        }
        String encodedPassword = CryptUtil.bCryptEncode(password);
        if (!Objects.equals(userModel.getPassword(), encodedPassword)) {
            throw new UtilException("用户名或密码错误");
        }
        return userModel;
    }

    public UserModel query(Long id) {
        return userRepository.queryById(id);
    }

    public List<UserModel> listHead(int row) {
        return userRepository.listHead(row);
    }
}
