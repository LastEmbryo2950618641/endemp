package cn.personal.endemp.security;

import cn.personal.endemp.entity.SysPermission;
import cn.personal.endemp.mapper.PermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @ Author     ：
 * @ Date       ：Created in 22:57 2019/5/22
 * @ Description：
 * @ Modified By：
 * @Version: $
 */

@Component
public class CustInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private PermissionDao permissionDao;

    private HashMap<String,Collection<ConfigAttribute>> map = null;

    /**
     * 加载权限表中所有权限
     * @param
     * @return
     * @throws IllegalArgumentException
     */
    public void loadResourceDefine(){
        map = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        List<SysPermission> permissions = permissionDao.findAll();
        for (SysPermission permission:permissions)
        {
            array = new ArrayList<>();
            cfg = new SecurityConfig(permission.getName());

            array.add(cfg);

            map.put(permission.getUrl(),array);


        }
    }
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        if(map == null)
        {
            loadResourceDefine();
        }

        HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;

        for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if(matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
