package com.peiyuzhen.pms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }
    public void addInterceptors(InterceptorRegistry registry) {
        String exclude[]=new String[]{"/","/doLogin","/login/**","/lib/**","/statics/**","/wxLogin"};
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**").excludePathPatterns(exclude);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       /* registry.addResourceHandler("/lib/").addResourceLocations("classpath:/static/lib/");
        registry.addResourceHandler("/login/").addResourceLocations("classpath:/static/login/");
        registry.addResourceHandler("/statics/").addResourceLocations("classpath:/static/statics/");*/

    }

}
