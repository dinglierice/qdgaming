package com.qdgaming.controller.config;

import com.qdgaming.controller.config.interceptor.AuthInterceptor;
import com.qdgaming.controller.config.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.*;

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
        registry.addInterceptor(new AuthInterceptor())
                .excludePathPatterns("/login")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
//        registry.addInterceptor(new TestInterceptor());
        //添加监控拦截器
        //registry.addInterceptor(new FootprintInterceptor(AppType.MANAGE));
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/null/api-docs",
                "/api-docs").setKeepQueryParams(true);
        registry.addRedirectViewController("/null/swagger-resources/configuration/ui",
                "/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/null/swagger-resources/configuration/security",
                "/swagger-resources/configuration/security");
        registry.addRedirectViewController("/null/swagger-resources", "/swagger-resources");
    }
}
