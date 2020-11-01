package cn.lilq.cloudsecurity.thirdpartyauthorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: Li Liangquan
 * @date: 2020/10/31 10:52
 * 第三方授权服务器
 */

@EnableResourceServer
@EnableAuthorizationServer
@SpringBootApplication
public class ThirdPartyAuthorizationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThirdPartyAuthorizationApplication.class,args);
    }
}