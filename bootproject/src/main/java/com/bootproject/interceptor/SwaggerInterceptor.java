package com.bootproject.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Swagger拦截器
 * @author 189****3363
 * @date 2021/05/11 09:30
 */
@Component
public class SwaggerInterceptor implements HandlerInterceptor {
  
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${swagger.enabled:false}")
    private Boolean enabledSwagger;

    @Value("${swagger.redirect-uri:/}")
    private String redirectUri;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!enabledSwagger) {
            String uri = request.getContextPath();
            if (StringUtils.isNotBlank(redirectUri))
                uri = request.getContextPath() + redirectUri;
            if (StringUtils.isBlank(uri))
                uri = "/";
            try {
                response.sendRedirect(uri);
            } catch (IOException e) {
                log.error(String.format("Redirect to '%s' for swagger throw an exception : %s", uri, e.getMessage()), e);
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}