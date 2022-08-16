package com.paul.minhr.config.https;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Paul.x
 * @Date 2022/8/15 22:43
 * @Description 为了解决访问http失败问题, 将其重定向到https
 */
@Configuration
public class TomcatConfig {
//    @Bean
//    TomcatServletWebServerFactory tomcatServletWebServerFactory() {
//        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory(){
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint constraint = new SecurityConstraint();
//                //Confidential
//                constraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                constraint.addCollection(collection);
//                context.addConstraint(constraint);
//            }
//        };
//        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(createConnector());
//        return tomcatServletWebServerFactory;
//    }
//
//    private Connector createConnector(){
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setScheme("http");
//        //Connector监听的http的默认端口号80
//        connector.setPort(8080);
//        connector.setSecure(false);
//        //监听到http的端口号后 会 重定向用Get方法 到的https的端口号,也就是项目配置的port
//        connector.setRedirectPort(443);
//        return connector;
//    }
}
