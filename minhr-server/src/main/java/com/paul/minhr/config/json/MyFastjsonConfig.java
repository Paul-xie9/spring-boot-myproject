package com.paul.minhr.config.json;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Author Paul.x
 * @Date 2022/8/16 1:18
 * @Description FastJson的配置类
 */
@Configuration
public class MyFastjsonConfig {
    /**
     * FastJson需要配置之后才能使用
     * @return
     */
    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        //日期格式
        config.setDateFormat("yyyy-MM-dd");
        //数据编码
        config.setCharset(StandardCharsets.UTF_8);
        config.setSerializerFeatures(
                //是否在生成的JSON中输出类名
                SerializerFeature.WriteClassName,
                //是否输出value为null的数据
                SerializerFeature.WriteMapNullValue,
                //生成的JSON格式化
                SerializerFeature.PrettyFormat,
                //空集合输出[]而非null
                SerializerFeature.WriteNullListAsEmpty,
                //空字符串输出""而非null
                SerializerFeature.WriteNullStringAsEmpty
        );
        converter.setFastJsonConfig(config);
        return converter;
    }
}
