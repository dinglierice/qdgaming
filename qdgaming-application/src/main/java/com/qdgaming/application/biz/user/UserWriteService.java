package com.qdgaming.application.biz.user;

import com.qdgaming.domain.biz.user.model.UserModel;
import com.qdgaming.domain.biz.user.service.UserService;
import com.qdgaming.repository.dto.user.UserDTO;
import com.qdgaming.repository.orm.convert.UserConverter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/11/25 20:29
 */
@Service
public class UserWriteService {
    @Resource
    UserService userService;

    public UserDTO register(String userName, String password) {
        UserModel register = userService.register(userName, password);
        return UserConverter.convertUserModel2UserDTO(register);
    }
}
