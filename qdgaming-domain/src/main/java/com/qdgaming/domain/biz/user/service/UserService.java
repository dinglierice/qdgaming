package com.qdgaming.domain.biz.user.service;

import com.qdgaming.domain.biz.user.model.UserModel;
import com.qdgaming.domain.biz.user.repository.UserRepository;
import com.qdgaming.utility.exception.UtilException;
import com.qdgaming.utility.util.CryptUtil;
import org.apache.commons.codec.digest.Crypt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
}
