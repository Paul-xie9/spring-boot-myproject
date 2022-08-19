package com.paul.springbootsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author Paul.x
 * @Date 2022/8/19 6:44
 * @Description
 *
 * prePostEnabled=true会解锁@PreAuthorize和@PostAuthorize两个注解，顾名思义，
 * @PreAuthorize注解会在方法执行前进行验证，而@PostAuthorize注解在方法执行后进行验证。
 * securedEnabled=true会解锁@Secured注解。
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        //密码不加密
//        return NoOpPasswordEncoder.getInstance();
//    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                //普通用户
                .withUser("paul").password("root").roles("user")
                .and()
                //两种管理员
                .withUser("admin").password("root").roles("admin","root")
                .and()
                .withUser("HR").password("root").roles("admin","hr");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin/**").hasRole("admin")
//                .antMatchers("/user/**").access("hasAnyRole('admin','user')")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginProcessingUrl("/login").permitAll()
//                .and()
//                .csrf().disable();

        http.antMatcher("/oauth/**").authorizeRequests()
                .antMatchers("/oauth/**").permitAll()
                .and().csrf().disable();
    }
}
