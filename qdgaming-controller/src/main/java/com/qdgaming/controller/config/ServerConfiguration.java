package com.qdgaming.controller.config;

import com.qdgaming.controller.config.interceptor.AuthInterceptor;
import com.qdgaming.controller.config.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description：TODO
 * @author：dinglie
 * @date：2023/11/26 23:25
 */
@Configuration
@EnableScheduling
@EnableWebMvc
public class ServerConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //Trace拦截器
        //registry.addInterceptor(new TraceInterceptor());
        //添加权限拦截器
//        registry.addInterceptor(new AuthInterceptor());
        registry.addInterceptor(new TestInterceptor());
        //添加监控拦截器
        //registry.addInterceptor(new FootprintInterceptor(AppType.MANAGE));
    }
}
