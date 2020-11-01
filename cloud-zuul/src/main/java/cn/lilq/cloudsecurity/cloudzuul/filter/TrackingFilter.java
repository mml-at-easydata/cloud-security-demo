package cn.lilq.cloudsecurity.cloudzuul.filter;

import cn.lilq.cloudsecurity.cloudzuul.util.FilterUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @auther: Li Liangquan
 * @date: 2020/10/28 12:58
 * 前置过滤器
 */

@Component
public class TrackingFilter extends ZuulFilter {
    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;//是否执行
    private static final Logger logger = LoggerFactory.getLogger(TrackingFilter.class);

    @Autowired
    FilterUtil filterUtil;

    /**
     * 指定类型 前置过滤器
     * @return "pre"
     */
    @Override
    public String filterType() {
        return FilterUtil.PRE_FILTER_TYPE;
    }

    /**
     * 指定执行顺序
     * @return 1
     */
    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    /**
     * 指定该过滤器是否执行
     * @return true
     */
    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() throws ZuulException {
        if (isCorrelationIdPresent()){
            System.out.println("tmx-id:"+filterUtil.getCorrelationId());
            logger.debug("发现关联id---前置过滤器: {}.",filterUtil.getCorrelationId());
        }else {
            filterUtil.setCorrelationId(generateCorrelationId());
            logger.debug("生成关联id---前置过滤器: {}.",filterUtil.getCorrelationId());
        }
        RequestContext context = RequestContext.getCurrentContext();
        logger.debug("处理传入的请求-- 前置过滤器: {}.",context.getRequest().getRequestURL());
        return null;
    }

    /**
     * 检查"tmx-correlation-id"是否存在
     * @return 存在返回true 否则返回false
     */
    private boolean isCorrelationIdPresent(){
        return filterUtil.getCorrelationId() != null;
    }

    /**
     * 生成UUID
     * @return UUID
     */
    private String generateCorrelationId(){
        return UUID.randomUUID().toString();
    }
}
