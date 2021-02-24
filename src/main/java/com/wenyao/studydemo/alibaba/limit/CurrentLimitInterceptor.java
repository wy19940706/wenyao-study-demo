package com.wenyao.studydemo.alibaba.limit;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description api限流拦截器
 * @author wenyao
 * @Date 2021/1/17 下午2:23
 */
@Slf4j
@Component
public class CurrentLimitInterceptor implements HandlerInterceptor {

    @Resource
    private RedisTemplate<String, Integer> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 通过HandlerMethod获取方法ApiLimit注解
            ApiLimit apiLimit = handlerMethod.getMethodAnnotation(ApiLimit.class);
            // 如果此方法存在限流注解
            if (apiLimit != null) {
                int maxRequestCount = apiLimit.maxRequestCount();
                long limitTime = apiLimit.limitTime();
                // 如果次数和时间限制都大于0证明此处需要限流
                if (limitTime > 0 && maxRequestCount > 0) {
                    String key = apiLimit.apiName();
                    // 获取reids缓存中该api的访问次数
                    Integer numberOfRedis = redisTemplate.opsForValue().get(key);
                    // 如果是第一次访问，则设置此api访问此api次数为1，并设置失效时间为注解中的时间
                    if (numberOfRedis == null) {
                        redisTemplate.opsForValue().set(key, 1, limitTime, TimeUnit.SECONDS);
                        return true;
                    }
                    // 如果访问次数大于注解设定则抛出异常
                    if (numberOfRedis > maxRequestCount) {
                        throw new RuntimeException("请求频繁，请稍后重试！");
                    }
                    // 如果满足限流条件则更新缓存次数
                    redisTemplate.opsForValue().set(key, numberOfRedis + 1);
                }
            }
        }
        return true;
    }
}
