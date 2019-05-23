package cn.personal.endemp.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

/**
 * @ Author     ：
 * @ Date       ：Created in 22:17 2019/5/22
 * @ Description：
 * @ Modified By：
 * @Version: $
 */

@Component
public class CustAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        if (collection == null || collection.size() <= 0)
        {
            return;
        }

        ConfigAttribute c;
        String needRole;
        for (Iterator<ConfigAttribute> iter = collection.iterator();iter.hasNext();)
        {
            c = iter.next();

            needRole = c.getAttribute();
            for (GrantedAuthority grantedAuthority:
                    authentication.getAuthorities()) {

                if (needRole.trim().equals(grantedAuthority.getAuthority())){
                    return;
                }

            }
        }

        throw new AccessDeniedException("no permisssion");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
