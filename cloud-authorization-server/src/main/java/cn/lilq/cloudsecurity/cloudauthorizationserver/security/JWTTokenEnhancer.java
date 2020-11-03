package cn.lilq.cloudsecurity.cloudauthorizationserver.security;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: Li Liangquan
 * @date: 2020/11/1 16:46
 * 令牌增强器类 增加JWT字段
 */
public class JWTTokenEnhancer implements TokenEnhancer {
//    @Autowired
//    private OrgUserRepository orgUserRepo;

    /**
     * 根据name 获取id 数据库
     * @param userName name
     * @return id
     */
    private String getOrgId(String userName){
        return userName+"--hello world";
    }
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
        String orgId =  getOrgId(authentication.getName());
        additionalInfo.put("test", orgId);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}

