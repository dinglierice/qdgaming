package com.qdgaming.controller.biz.user;

import com.qdgaming.application.biz.user.UserWriteService;
import com.qdgaming.controller.base.BaseController;
import com.qdgaming.application.base.request.UserRegisterRequest;
import com.qdgaming.controller.base.result.WebResult;
import com.qdgaming.repository.dto.user.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @RequestMapping("/register")
    public WebResult<?> register(
            @RequestParam String userName,
            @RequestParam String password
    ) {
        UserDTO userDTO = userWriteService.register(userName, password);
        return success(userDTO);
    }

    @GetMapping("/query/{id}")
    public WebResult<?> query(@PathVariable("id") Long id) {
        UserDTO query = userWriteService.query(id);
        return success(query);
    }
}
