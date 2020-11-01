package cn.lilq.cloudsecurity.cloudbookserver.controller;

import cn.lilq.cloudsecurity.cloudapicommon.pojo.Order;
import cn.lilq.cloudsecurity.cloudapicommon.pojo.Response;
import cn.lilq.cloudsecurity.cloudbookserver.service.OrderClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: Li Liangquan
 * @date: 2020/11/1 13:52
 */

@Controller
@DefaultProperties(
        commandProperties = {
                //配置连接超时
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "10000"),
                //熔断触发的最小个数/10s
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
                //熔断多少秒开始尝试请求
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMillisecond",value = "30"),
                //失败率熔断
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "10")
        },
        //指定线程池名称
        threadPoolKey = "clientThreadPool",
        threadPoolProperties = {
                //设置线程池中线程数
                @HystrixProperty(name = "coreSize",value = "50"),
                //单个线程繁忙时间可排队的请求数的队列大小
                @HystrixProperty(name = "maxQueueSize",value = "20")
        })
public class ClientCon {
        @Autowired
        private OrderClient orderClient;

        /**
         * 消费Book
         * @param order 订单
         * @return response
         */
        @ResponseBody
        @RequestMapping(value = "/book/shop",method = RequestMethod.POST)
        public Response shopBook(@RequestBody Order order){
                /**
                 * 生成订单
                 * book 数量减1
                 */
                return orderClient.addOrder(order);
        }

        /**
         * JWT test
         * @param test test
         * @return response
         */
        @ResponseBody
        @RequestMapping(value = "/book/shop/test",method = RequestMethod.GET)
        public Response shopTest(@RequestHeader(value = "tmx-test-id") String test){
                return orderClient.getTest(test);
        }
}
