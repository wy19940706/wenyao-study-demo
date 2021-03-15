package com.wenyao.studydemo.alibaba.limit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wenyao
 * @Description
 * @Date 2021/1/17 下午2:22
 */
@Slf4j
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

//    @Autowired
//    private CurrentLimitInterceptor currentLimitInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(currentLimitInterceptor);
//    }


}
