package com.qdgaming.controller.biz.user;

import com.qdgaming.application.biz.user.UserWriteService;
import com.qdgaming.controller.auth.Feature;
import com.qdgaming.controller.auth.FeatureType;
import com.qdgaming.controller.auth.LoginStoreService;
import com.qdgaming.controller.base.BaseController;
import com.qdgaming.application.base.request.UserRegisterRequest;
import com.qdgaming.controller.base.result.WebResult;
import com.qdgaming.repository.dto.user.UserDTO;
import com.qdgaming.utility.util.StringUtil;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @RequestMapping("/test_query")
    @Feature(FeatureType.TEST)
    public WebResult<?> test() {
        List<UserDTO> userDTO = userWriteService.listUsers(5);
        return success(userDTO);
    }


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

        UserDTO user = userWriteService.login(username, password);

        //设置cookie.
        String key = StringUtil.uuid();
        Cookie cookie = new Cookie(LoginStoreService.USER_COOKIE_KEY, key);
        cookie.setMaxAge(60 * 60 * 24 * 365);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        loginStoreService.storeLoginUser(key, user);

        return success(user);
    }
}
