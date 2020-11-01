package cn.lilq.cloudsecurity.cloudauthorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @auther: Li Liangquan
 * @date: 2020/11/1 16:34
 */

@EnableResourceServer
@EnableAuthorizationServer
@SpringBootApplication
public class CloudAuthorizationServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudAuthorizationServerApplication.class,args);
    }
}