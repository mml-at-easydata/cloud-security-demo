package cn.lilq.cloudsecurity.cloudbookserver.controller;

import cn.lilq.cloudsecurity.cloudapicommon.pojo.Order;
import cn.lilq.cloudsecurity.cloudapicommon.pojo.Response;
import cn.lilq.cloudsecurity.cloudbookserver.entity.Book;
import cn.lilq.cloudsecurity.cloudbookserver.service.BookService;
import cn.lilq.cloudsecurity.cloudbookserver.service.OrderClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: Li Liangquan
 * @date: 2020/10/31 15:07
 */

@Controller
@DefaultProperties(defaultFallback = "fallback",
        commandProperties = {
                //配置连接超时
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000"),
        },
        //指定线程池名称
        threadPoolKey = "bookThreadPool",
        threadPoolProperties = {
                //设置线程池中线程数
                @HystrixProperty(name = "coreSize",value = "50"),
                //单个线程繁忙时间可排队的请求数的队列大小
                @HystrixProperty(name = "maxQueueSize",value = "20")
        })
public class BookCon {
    @Autowired
    private BookService bookService;
    @Autowired
    private OrderClient orderClient;

    /**
     * book 列表
     * @return books
     */
    @ResponseBody
    @RequestMapping(value="/book", method= RequestMethod.GET)
    @HystrixCommand
    public Response list() {
        return bookService.listBook();
    }

    /**
     * 查询指定book
     * @param id book-id
     * @return book
     */
    @ResponseBody
    @RequestMapping(value="/book/{id}", method= RequestMethod.GET)
    @HystrixCommand
    public Response getBook(@PathVariable String id) {
        return bookService.findBookById(new Book(id,null,null,null));
    }

    /**
     * 添加book
     * @param book book
     * @return response
     */
    @ResponseBody
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    @HystrixCommand
    public Response addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }


    /**
     * 修改book
     * @param book book
     * @return response
     */
    @ResponseBody
    @RequestMapping(value = "/book",method = RequestMethod.PUT)
    @HystrixCommand
    public Response updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    public Response fallback(){
        return new Response(500,"server error",null);
    }
}
