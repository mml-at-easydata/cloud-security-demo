package cn.lilq.cloudsecurity.cloudzuul.util;

import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

/**
 * @auther: Li Liangquan
 * @date: 2020/10/28 13:10
 */

@Component
public class FilterUtil {
    /**
     * 过滤器的类型。可选值有：
     * pre - 前置过滤
     * route - 路由后过滤
     * error - 异常过滤
     * post - 远程服务调用后过滤
     */
    public static final String PRE_FILTER_TYPE = "pre";
    public static final String ROUTE_FILTER_TYPE = "route";
    public static final String ERROR_FILTER_TYPE = "error";
    public static final String POST_FILTER_TYPE = "post";

    public static final String CORRELATION_ID="tmx-correlation-id";

    /**
     * 获取 "tmx-correlation-id"
     * @return
     */
    public String getCorrelationId() {
        RequestContext context = RequestContext.getCurrentContext();

        if (context.getRequest().getHeader(CORRELATION_ID) != null){
            return context.getRequest().getHeader(CORRELATION_ID);
        }else {
            return context.getZuulRequestHeaders().get(CORRELATION_ID);
        }
    }

    /**
     * 设置请求头 增加 "tmx-correlation-id"
     * @param correlationId "tmx-correlation-id"
     */
    public void setCorrelationId(String correlationId){
        RequestContext context = RequestContext.getCurrentContext();
        context.addZuulRequestHeader(CORRELATION_ID,correlationId);
    }

}
