package cn.lilq.cloudsecurity.cloudorderserver.dao;

import cn.lilq.cloudsecurity.cloudorderserver.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther: Li Liangquan
 * @date: 2020/11/1 09:13
 * order dao jpa
 */
@Repository
public interface OrderDAO extends JpaRepository<Order,String> {

}
