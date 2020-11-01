package cn.lilq.cloudsecurity.cloudbookserver.service;

import cn.lilq.cloudsecurity.cloudapicommon.pojo.Order;
import cn.lilq.cloudsecurity.cloudapicommon.pojo.Response;
import cn.lilq.cloudsecurity.cloudbookserver.config.FeignConfig;
import cn.lilq.cloudsecurity.cloudbookserver.service.impl.FallbackOrderClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: Li Liangquan
 * @date: 2020/11/1 11:41
 * 订单客户端
 */

@Component
@FeignClient(name = "CLOUD-ORDER-SERVER",fallback = FallbackOrderClient.class ,configuration = FeignConfig.class)
public interface OrderClient {
    @ResponseBody
    @RequestMapping(value = "/order",method = RequestMethod.POST)
    Response addOrder(@RequestBody Order order);

    @ResponseBody
    @RequestMapping(value = "/order/test",method = RequestMethod.GET)
    Response getTest(@RequestHeader(value = "tmx-test-id") String test);
}
