package com.bootproject.service;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

/**
 * 单元测试基类
 * @author 189****3363
 * @date 2021/05/11 09:30
 */
@ComponentScan("com.bootproject")
public class BaseTest {
  
    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 打印测试结果
     * @author 189****3363
     * @date 2021/05/11 09:30
     */
    protected void print(Object obj) {
        log.info("测试结果: {}", obj == null ? "无返回" : JSON.toJSONString(obj));
    }

}