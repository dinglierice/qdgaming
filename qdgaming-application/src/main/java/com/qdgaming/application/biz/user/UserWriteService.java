package com.qdgaming.application.biz.user;

import com.qdgaming.domain.biz.user.model.UserModel;
import com.qdgaming.domain.biz.user.service.UserService;
import com.qdgaming.repository.dto.user.UserDTO;
import com.qdgaming.repository.orm.convert.UserConverter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

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

    public UserDTO query(Long id) {
        UserModel query = userService.query(id);
        return UserConverter.convertUserModel2UserDTO(query);
    }

    public List<UserDTO> listUsers(int row) {
        List<UserModel> userModels = userService.listHead(row);
        if (null == userModels) {
            return null;
        }
        return userModels.stream().map(UserConverter::convertUserModel2UserDTO).collect(Collectors.toList());
    }

    public UserDTO login(String userName, String password) {
        UserModel userModel = userService.login(userName, password);
        return UserConverter.convertUserModel2UserDTO(userModel);
    }
}
