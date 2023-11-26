package com.qdgaming.controller.biz.user;

import com.qdgaming.application.biz.user.UserWriteService;
import com.qdgaming.controller.auth.Feature;
import com.qdgaming.controller.auth.FeatureType;
import com.qdgaming.controller.auth.LoginStoreService;
import com.qdgaming.controller.base.BaseController;
import com.qdgaming.application.base.request.UserRegisterRequest;
import com.qdgaming.controller.base.result.WebResult;
import com.qdgaming.repository.dto.user.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/11/25 20:08
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {

    @Resource
    UserWriteService userWriteService;

    @Resource
    LoginStoreService loginStoreService;

    @RequestMapping("/register")
    @Feature(FeatureType.PUBLIC)
    public WebResult<?> register(
            @RequestParam String userName,
            @RequestParam String password
    ) {
        UserDTO userDTO = userWriteService.register(userName, password);
        return success(userDTO);
    }

    @GetMapping("/query/{id}")
    @Feature(FeatureType.USER_LOGIN)
    public WebResult<?> query(@PathVariable("id") Long id) {
        UserDTO query = userWriteService.query(id);
        return success(query);
    }

    @Feature(FeatureType.PUBLIC)
    @PostMapping("/login")
    public WebResult<?> login(@RequestParam String username,
                              @RequestParam String password,
                              HttpServletRequest request,
                              HttpServletResponse response) {
        // TODO 写登录逻辑
        return null;
    }
}
