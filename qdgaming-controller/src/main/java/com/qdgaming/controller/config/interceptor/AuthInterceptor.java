package com.qdgaming.controller.config.interceptor;

import com.qdgaming.controller.auth.LoginStoreService;
import com.qdgaming.utility.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/11/26 23:27
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //后台接口不缓存内容，否则IE会出现数据不更新的bug.
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // TODO 这里用非SpringBean工具类来实现
        LoginStoreService loginStoreService = SpringContextUtil.getBean(LoginStoreService.class);
        return loginStoreService.doAuthIntercept(request, response, handler);

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
