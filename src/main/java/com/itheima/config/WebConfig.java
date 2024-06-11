package com.itheima.config;

import com.itheima.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration  //配置类
public class WebConfig implements WebMvcConfigurer {
    //自定义的拦截器对象
    @Resource
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册自定义拦截器对象
        // 对login、knife4j在线接口页面的请求不进行拦截
        String[] excludePatterns = new String[]{"/login", "/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**",
                "/api", "/api-docs", "/api-docs/**", "/doc.html/**"};

        registry.addInterceptor(loginCheckInterceptor).
                addPathPatterns("/**")      // 设置拦截器拦截的请求路径（ /** 表示拦截所有请求）
                .excludePathPatterns(excludePatterns); // 设置排除拦截的路径
    }
}