package cn.lilq.cloudsecurity.cloudorderserver.service.impl;

import cn.lilq.cloudsecurity.cloudapicommon.pojo.Order;
import cn.lilq.cloudsecurity.cloudapicommon.pojo.Response;
import cn.lilq.cloudsecurity.cloudorderserver.dao.OrderDAO;
import cn.lilq.cloudsecurity.cloudorderserver.service.OrderService;
import cn.lilq.cloudsecurity.cloudorderserver.util.OrderTransformUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auther: Li Liangquan
 * @date: 2020/11/1 09:33
 * Order输出类选择common 屏蔽Order Server 实现细节
 */

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDAO orderDAO;

    @Override
    public Response addOrder(cn.lilq.cloudsecurity.cloudapicommon.pojo.Order order) {
        if (order.getId()!=null)
            return new Response(400,"Id must be null",null);
        if (order.getGoodsId()==null || order.getUserId()==null)
            return new Response(400,"content is null",null);
        if (order.getDate()==null)
            order.setDate(new Date());
        return new Response(200,"successful",OrderTransformUtil.entityToPojo(orderDAO.save(OrderTransformUtil.pojoToEntity(order))));
    }

    @Override
    public Response listOrder() {
        List<cn.lilq.cloudsecurity.cloudapicommon.pojo.Order> ordersNew = new ArrayList<>();
        List<cn.lilq.cloudsecurity.cloudorderserver.entity.Order> orders = orderDAO.findAll();
        orders.forEach(order ->
                ordersNew.add(OrderTransformUtil.entityToPojo(order))
        );
        return new Response(200,"successful",ordersNew);
    }

    @Override
    public Response findOrderById(cn.lilq.cloudsecurity.cloudapicommon.pojo.Order order) {
        if(order.getId()==null)
            return new Response(400,"id is null",null);
        return orderDAO.findById(order.getId())
                .map(value ->
                    new Response(200,"successful",OrderTransformUtil.entityToPojo(value))
                ).orElseGet(() -> new Response(404, "order is not exist", null));
    }

    @Override
    public Response updateOrder(cn.lilq.cloudsecurity.cloudapicommon.pojo.Order order) {
        if (order.getId()==null || order.getUserId()==null || order.getDate()==null || order.getGoodsId()==null){
            return new Response(400,"content is null",null);
        }
        return new Response(200,"successful",OrderTransformUtil.entityToPojo(orderDAO.save(OrderTransformUtil.pojoToEntity(order))));
    }
}
