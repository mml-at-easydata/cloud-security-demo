package cn.lilq.cloudsecurity.thirdpartyauthorization.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @auther: Li Liangquan
 * @date: 2020/10/29 18:47
 * 定义个人凭据及其所属的角色
 * 要配置OAuth2 服务器以验证用户ID
 */

@Configuration
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {

    /**
     * AuthenticationManager被用来Spring security用来处理验证
     * @return AuthenticationManager
     * @throws Exception e
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    /**
     * Spring security使用UserDetailsService处理返回的用户信息，这些用户信息将由 Spring security 返回
     * @return UserDetailsService
     * @throws Exception e
     */
    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }


    /**
     * 定义用户、密码、和角色
     * @param auth auth
     * @throws Exception e
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .passwordEncoder(NoOpPasswordEncoder.getInstance())
            .withUser("admin")
            .password("123456")
            .roles("USER", "ADMIN")
            .and()
            .passwordEncoder(NoOpPasswordEncoder.getInstance())
            .withUser("user")
            .password("123456")
            .roles("USER");
    }
}
