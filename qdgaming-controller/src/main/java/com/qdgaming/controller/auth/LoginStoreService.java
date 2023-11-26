package com.qdgaming.controller.auth;

import com.qdgaming.repository.dto.user.UserDTO;
import com.qdgaming.utility.exception.ExceptionCode;
import com.qdgaming.utility.exception.UtilException;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/11/26 21:15
 */
@Service
public class LoginStoreService {
    public static final String USER_COOKIE_KEY = "exy";
    Map<String, UserDTO> loginUsers = new HashMap<>();

    //从request中获取用户登录的token
    public String getAuthentication(HttpServletRequest request, String key) {

        if (request == null) {
            return null;
        }
        //尝试去验证token。
        Cookie[] cookies = request.getCookies();
        String authentication = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (key.equals(cookie.getName())) {
                    authentication = cookie.getValue();
                }
            }
        }

        //尝试从request中读取
        if (authentication == null) {
            authentication = request.getParameter(key);
        }

        return authentication;
    }

    //获取到当前这个链接的的request
    public HttpServletRequest getRequest() {
        try {
            RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
            ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
            return attributes.getRequest();
        } catch (Throwable throwable) {
            return null;
        }
    }

    public UserDTO findLoginUser() {
        HttpServletRequest request = getRequest();
        return this.findLoginUser(request);
    }

    public UserDTO findLoginUser(HttpServletRequest request) {
        String authentication = this.getAuthentication(request, USER_COOKIE_KEY);
        return this.loginUsers.get(authentication);
    }

    /**
     * 权限拦截方法，提供给拦截器使用
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Transactional
    public boolean doAuthIntercept(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) {
        HandlerMethod handlerMethod = null;
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        } else {
            try {
                handlerMethod = (HandlerMethod) handler;
                if (handlerMethod.getBeanType() == BasicErrorController.class) {
                    return true;
                }
            } catch (Exception e) {
                throw new UtilException("转换HandlerMethod出错，请及时排查。");
            }
        }
        Feature methodFeature = handlerMethod.getMethodAnnotation(Feature.class);
        if (methodFeature != null) {
            FeatureType[] types = methodFeature.value();
            if (FeatureType.PUBLIC.equals(types[0])) {
                return true;
            } else {
                List<FeatureType> featureTypeList = Arrays.asList(types);
                if (featureTypeList.contains(FeatureType.USER_LOGIN)) {
                    UserDTO loginUser = this.findLoginUser(request);
                    if (loginUser != null) {
                        return true;
                    }
                }
                throw new UtilException(ExceptionCode.LOGIN, "没有登录，禁止访问");
            }
        } else {
            throw new UtilException("您访问的接口{}不存在或者未配置Feature！", request.getRequestURI());
        }
    }
}
