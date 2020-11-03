package cn.lilq.cloudsecurity.cloudzuul.filter;

import cn.lilq.cloudsecurity.cloudzuul.config.ServiceConfig;
import com.netflix.zuul.context.RequestContext;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * @auther: Li Liangquan
 * @date: 2020/11/1 23:50
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
    public static final String TEST_ID = "tmx-test-id";
    public static final String AUTH_TOKEN = "Authorization";

    @Autowired
    private ServiceConfig serviceConfig;

    /**
     * 获取 "tmx-correlation-id"
     * @return "tmx-correlation-id"
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

    /**
     * 获取token
     * @return token
     */
    public final String getAuthToken(){
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.getRequest().getHeader(AUTH_TOKEN);
    }

    /**
     * 获取JWT token test内容
     * @param token token
     * @return test
     */
    public String getTest(String token){
        String result="";
        if (token!=null){

            String authToken = token.replace("Bearer ","");
            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(serviceConfig.getJwtSigningKey().getBytes(StandardCharsets.UTF_8))
                        .parseClaimsJws(authToken).getBody();
                result = (String) claims.get("test");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 设置请求头 增加 "tmx-test-id"
     * @param test test
     */
    public void setTest(String test){
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.addZuulRequestHeader(TEST_ID, test);
    }
}

