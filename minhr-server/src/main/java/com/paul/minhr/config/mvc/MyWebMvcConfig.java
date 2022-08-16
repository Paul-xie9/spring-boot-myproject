package com.paul.minhr.config.mvc;

import com.paul.minhr.Handler.MyHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author Paul.x
 * @Date 2022/8/16 1:37
 * @Description
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    /**
     * 配置全局跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //addMapping表示对哪种格式的请求路径进行跨域处理
        registry.addMapping("/b/*")
                //allowedHeaders表示允许的请求头，默认允许所有的请求头信息
                .allowedHeaders("*")
                //allowedMethods表示允许的请求方法，默认是GET、POST和HEAD
                .allowedMethods("*")
                //maxAge表示探测请求的有效期
                .maxAge(1800)
                //allowedOrigins表示支持的域
                .allowedOrigins("http://localhost:8081");
    }

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHandlerInterceptor())
                //拦截路径
                .addPathPatterns("/**")
                //排除的路径
                .excludePathPatterns("/t");
    }

    /**
     * 静态资源过滤策略
     * 如果yml配置文件中已经定义了,这里就可以不用定义
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
