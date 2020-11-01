package cn.lilq.cloudsecurity.cloudorderserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @auther: Li Liangquan
 * @date: 2020/11/1 09:01
 */

@EnableEurekaClient
@EnableHystrix
@EnableDiscoveryClient
@EnableResourceServer
@SpringBootApplication
public class CloudOrderServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudOrderServerApplication.class,args);
    }
}
