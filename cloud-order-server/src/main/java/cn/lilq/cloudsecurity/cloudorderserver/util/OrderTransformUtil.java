package cn.lilq.cloudsecurity.cloudorderserver.util;

import cn.lilq.cloudsecurity.cloudapicommon.pojo.Order;

/**
 * @auther: Li Liangquan
 * @date: 2020/11/1 11:14
 * 订单转换类 Entity pojo 转换
 */
public class OrderTransformUtil {
    /**
     * 数据库对象转pojo对象
     * @param order entity order
     * @return pojo
     */
    static public Order entityToPojo(cn.lilq.cloudsecurity.cloudorderserver.entity.Order order){
        return  new Order(order.getId(),order.getUserId(),order.getGoodsId(),order.getDate());
    }

    /**
     * pojo对象转数据库对象
     * @param order pojo对象
     * @return entity
     */
    static public cn.lilq.cloudsecurity.cloudorderserver.entity.Order pojoToEntity(Order order){
        return  new cn.lilq.cloudsecurity.cloudorderserver.entity.Order(order.getId(),order.getUserId(),order.getGoodsId(),order.getDate());
    }
}
