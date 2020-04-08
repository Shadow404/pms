package com.peiyuzhen.pms.config;


import com.peiyuzhen.pms.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j

public class MyInterceptor implements HandlerInterceptor {
    @Resource
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        ValueOperations<String ,String> opsForValue=redisTemplate.opsForValue();
        log.info("{}redis",redisTemplate);


       User user= (User) httpServletRequest.getSession().getAttribute("user");
       String wxSessionId=httpServletRequest.getHeader("Cookie");
        String sessionId=opsForValue.get(String.valueOf(wxSessionId.hashCode()));
       if(user!=null||(sessionId.equals(wxSessionId))) {
            //log.info("成功！");
            return true;    //如果false，停止流程，api被拦截
        }else {

           httpServletResponse.sendRedirect("/");
            return false;
        }

    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
