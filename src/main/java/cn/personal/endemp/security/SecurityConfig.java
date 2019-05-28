package cn.personal.endemp.security;

import cn.personal.endemp.security.filter.CustSecurityAccessFilter;
import cn.personal.endemp.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @ Author     ：liui
 * @ Date       ：Created in 19:30 2019/5/17
 * @ Description：安全框架配置
 * @ Modified By：
 * @Version: no$
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustUserDetailService custUserDetailService;

    @Autowired
    CustSecurityAccessFilter custSecurityAccessFilter;

    @Override
    public void configure(WebSecurity web) throws Exception {
       web.ignoring().antMatchers("/static/**","/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);

        auth.userDetailsService(custUserDetailService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return MD5Util.encode((String) charSequence);
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals((String)charSequence);
            }
        });
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // super.configure(http);
        http.authorizeRequests()
                .antMatchers("/login*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error")
                .loginProcessingUrl("/loginHandle")
                .successForwardUrl("/index")
                .and()
                .logout()
                .logoutSuccessUrl("/index");

        http.addFilterBefore(custSecurityAccessFilter, FilterSecurityInterceptor.class);




    }


}
