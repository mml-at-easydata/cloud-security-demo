package cn.lilq.cloudsecurity.cloudorderserver.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @auther: Li Liangquan
 * @date: 2020/11/1 10:13
 * 配置保护规则
 */


//public class ResourceServerConfiguration{
//
//}

@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        //现在全部
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/order/**")
                .hasRole("ADMIN")
                .anyRequest()
                .authenticated();
    }
}