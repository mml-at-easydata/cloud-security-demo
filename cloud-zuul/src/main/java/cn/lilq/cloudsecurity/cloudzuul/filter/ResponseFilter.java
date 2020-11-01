package cn.lilq.cloudsecurity.cloudzuul.filter;

import cn.lilq.cloudsecurity.cloudzuul.util.FilterUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auther: Li Liangquan
 * @date: 2020/10/28 16:02
 * 后置过滤器
 */

@Component
public class ResponseFilter extends ZuulFilter {
    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;//是否执行

    private static final Logger logger = LoggerFactory.getLogger(TrackingFilter.class);

    @Autowired
    FilterUtil filterUtil;

    @Override
    public String filterType() {
        return FilterUtil.POST_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        logger.debug("将关联id添加到响应头---后置过滤器: {}.",filterUtil.getCorrelationId());
        context.getResponse().addHeader(FilterUtil.CORRELATION_ID,filterUtil.getCorrelationId());
        logger.debug("完成传出的请求URL---后置过滤器: {}.",context.getRequest().getRequestURL());
        return null;
    }
}
