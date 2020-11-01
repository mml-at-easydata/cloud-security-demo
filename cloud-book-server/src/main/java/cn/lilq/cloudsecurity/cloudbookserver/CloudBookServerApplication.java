package cn.lilq.cloudsecurity.cloudbookserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @auther: Li Liangquan
 * @date: 2020/10/31 15:23
 * book 服务
 */

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableDiscoveryClient
@EnableResourceServer
@EnableFeignClients
public class CloudBookServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudBookServerApplication.class, args);
    }
}
