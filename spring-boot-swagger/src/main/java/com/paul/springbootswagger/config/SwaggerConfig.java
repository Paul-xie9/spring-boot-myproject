package com.paul.springbootswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author Paul.x
 * @Date 2022/8/22 2:04
 * @Description
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 通过apis方法配置要扫描的controller位置，通过paths方法配置路径
     * @return
     */
    @Bean
    Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.paul.springbootswagger.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfoBuilder());
    }

    /**
     * 构建文档的基本信息，例如描述、联系人信息、版本、标题等
     * @return
     */
    @Bean
    ApiInfo apiInfoBuilder(){
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.description("接口测试文档")
                .contact(new Contact("Paul’x","https://github.com/Paul-xie9/spring-boot-myproject",
                        "1109897635@qq.com"))
                .version("v1.0").title("Api测试文档").license("Apache2.0")
                .licenseUrl("").build();
        return apiInfoBuilder.build();
    }
}
