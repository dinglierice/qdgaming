package com.qdgaming.controller.biz.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/11/25 20:08
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @RequestMapping("/register")
    public WebResult<?> register(
            @RequestParam String username,
            @RequestParam String password
    ) {

        ReaderRegisterRequest request = new ReaderRegisterRequest(
                username,
                password
        );

        ReaderDTO readerDTO = readerWriteFacade.register(request);

        return success(readerDTO);
    }

}
