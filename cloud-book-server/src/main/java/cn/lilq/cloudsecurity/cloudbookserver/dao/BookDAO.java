package cn.lilq.cloudsecurity.cloudbookserver.dao;

import cn.lilq.cloudsecurity.cloudbookserver.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther: Li Liangquan
 * @date: 2020/10/26 20:04
 */

@Repository
public interface BookDAO extends JpaRepository<Book,String> {
}
