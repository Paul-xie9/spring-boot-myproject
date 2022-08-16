package com.paul.minhr.config.json;

//import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.lang.reflect.Modifier;

/**
 * @Author Paul.x
 * @Date 2022/8/16 1:07
 * @Description Gson配置
 */
@Configuration
public class GsonConfig {
//    /**
//     * 因为gson格式化日期需要自己配置,这里就是json配置日期格式
//     * @return
//     */
//    @Bean
//    GsonHttpMessageConverter gsonHttpMessageConverter(){
//        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
//        GsonBuilder builder = new GsonBuilder();
//        builder.setDateFormat("yyyy-MM-dd");
//        builder.excludeFieldsWithModifiers(Modifier.PROTECTED);
//        converter.setGson(builder.create());
//        return converter;
//    }
}
