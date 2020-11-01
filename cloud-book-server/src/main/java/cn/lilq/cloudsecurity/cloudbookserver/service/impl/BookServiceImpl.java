package cn.lilq.cloudsecurity.cloudbookserver.service.impl;

import cn.lilq.cloudsecurity.cloudapicommon.pojo.Response;
import cn.lilq.cloudsecurity.cloudbookserver.dao.BookDAO;
import cn.lilq.cloudsecurity.cloudbookserver.entity.Book;
import cn.lilq.cloudsecurity.cloudbookserver.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @auther: Li Liangquan
 * @date: 2020/10/31 14:23
 */

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource
    BookDAO bookDAO;
    @Override
    public Response addBook(Book book) {
        if (book.getId()!=null)
            return new Response(400,"Id must be null",null);
        if (book.getName()==null || book.getCategory()==null){
            return new Response(400,"content is null",null);
        }
        if (book.getRepertory()==null){
            book.setRepertory(0);
        }
        Book book1Save = bookDAO.save(book);
        return new Response(200,"successful",book1Save);
    }

    @Override
    public Response listBook() {
        return new Response(200,"successful",bookDAO.findAll());
    }

    @Override
    public Response findBookById(Book book) {
        if (book.getId()==null)
            return new Response(400,"id is null",null);
        return bookDAO.findById(book.getId()).map(value -> new Response(200,"successful",value)).orElseGet(() -> new Response(404, "person is not exist", null));
    }

    @Override
    public Response updateBook(Book book) {
        if (book.getName()==null || book.getCategory()==null || book.getId()==null || book.getRepertory()==null){
            return new Response(400,"content is null",null);
        }
        Book bookSave = bookDAO.save(book);
        return new Response(200,"successful",bookSave);
    }
}
