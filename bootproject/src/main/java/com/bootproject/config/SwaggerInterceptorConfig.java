package com.bootproject.config;

import com.bootproject.interceptor.SwaggerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Swagger拦截器配置
 * @author 189****3363
 * @date 2021/05/11 09:30
 */
@Configuration
public class SwaggerInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private SwaggerInterceptor swaggerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(swaggerInterceptor).addPathPatterns("/swagger-ui.html", "/doc.html");
    }
}