package com.bootproject.api;

import com.alibaba.fastjson.JSON;
import com.bootproject.core.model.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller基类
 * @author 189****3363
 * @date 2021/05/11 09:30
 */
public class BaseController {

    protected Logger log = LoggerFactory.getLogger(this.getClass());
  
    /**
     * 全局异常捕获
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandle(HttpServletRequest request, HttpServletResponse response, Exception ex){
        try {
            log.error(ex.getMessage(), ex);
            // 如果为异步请求，返回ApiResponse对象
            if(this.isAjax(request)){
                response.setHeader("content-type", "text/html;charset=UTF-8");
                response.getWriter().write(JSON.toJSONString(ApiResponse.failed(ex.getMessage())));
                return null;
            }
            // 跳转至error页面
            ModelMap model = new ModelMap();
            model.addAttribute("error", ex.getMessage());
            return new ModelAndView("error/default", model);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            ModelMap model = new ModelMap();
            model.addAttribute("error", "未知异常");
            return new ModelAndView("error/default", model);
        }
    }

    /**
     * 判断请求是否为异步
     */
    private boolean isAjax(HttpServletRequest request){
        return StringUtils.isNotBlank(request.getHeader("X-Requested-With"));
    }
}