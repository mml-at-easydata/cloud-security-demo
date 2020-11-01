package cn.lilq.cloudsecurity.cloudeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @auther: Li Liangquan
 * @date: 2020/10/31 10:40
 * 服务注册发现
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaServerApplication.class, args);
    }
}