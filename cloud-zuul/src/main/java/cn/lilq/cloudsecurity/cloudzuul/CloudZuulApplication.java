package cn.lilq.cloudsecurity.cloudzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @auther: Li Liangquan
 * @date: 2020/10/31 23:15
 * zuul 路由
 * 查看路由信息 http://127.0.0.1:8080/actuator/routes
 */

@EnableZuulProxy
@SpringBootApplication
public class CloudZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudZuulApplication.class,args);
    }
}
