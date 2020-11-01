package cn.lilq.cloudsecurity.cloudbookserver.service.impl;

import cn.lilq.cloudsecurity.cloudapicommon.pojo.Order;
import cn.lilq.cloudsecurity.cloudapicommon.pojo.Response;
import cn.lilq.cloudsecurity.cloudbookserver.service.OrderClient;
import org.springframework.stereotype.Component;

/**
 * @auther: Li Liangquan
 * @date: 2020/11/1 11:43
 * 订单客户端异常回调
 */

@Component
public class FallbackOrderClient implements OrderClient {

    @Override
    public Response addOrder(Order order) {
        System.out.println("错误回调");
        return new Response(500,"server error",null);
    }
}
