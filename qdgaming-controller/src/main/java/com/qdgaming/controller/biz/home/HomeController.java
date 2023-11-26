package com.qdgaming.controller.biz.home;

import com.qdgaming.controller.base.BaseController;
import org.springframework.web.bind.annotation.*;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/11/26 11:03
 */
@RestController
@RequestMapping("/home")
public class HomeController extends BaseController {

    @GetMapping("/hello/{userName}")
    public String hello(@PathVariable(value = "userName") String userName) {
        return "Hello " + userName;
    }
}
