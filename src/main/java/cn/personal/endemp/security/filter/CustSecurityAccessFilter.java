package cn.personal.endemp.security.filter;

import cn.personal.endemp.security.CustAccessDecisionManager;
import cn.personal.endemp.security.CustInvocationSecurityMetadataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ Author     ：
 * @ Date       ：Created in 22:24 2019/5/22
 * @ Description：
 * @ Modified By：
 * @Version: $
 */

@Component
public class CustSecurityAccessFilter extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    private CustInvocationSecurityMetadataSource custInvocationSecurityMetadataSource;

    @Autowired
    public void setMyAccessDecisionManager(CustAccessDecisionManager myAccessDecisionManager) {
        super.setAccessDecisionManager(myAccessDecisionManager);
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation(servletRequest ,servletResponse,filterChain);
        InterceptorStatusToken token = super.beforeInvocation(fi);

        try {

            fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
        }finally {
            super.afterInvocation(token,null);
        }

    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.custInvocationSecurityMetadataSource;
    }


}
