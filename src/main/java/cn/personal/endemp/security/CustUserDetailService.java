package cn.personal.endemp.security;

import cn.personal.endemp.entity.SysPermission;
import cn.personal.endemp.entity.SysUser;
import cn.personal.endemp.exception.UserNotFoundexception;
import cn.personal.endemp.mapper.PermissionDao;
import cn.personal.endemp.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：liuqi
 * @ Date       ：Created in 19:34 2019/5/17
 * @ Description：用户名获取密码，权限等信息
 * @ Modified By：
 * @Version: $
 */
@Service
public class CustUserDetailService implements UserDetailsService {


    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    PermissionDao permissionDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UserNotFoundexception {

        SysUser user = sysUserMapper.selectByUsername(s);


        if(user == null) {
            throw new UserNotFoundexception("没有此用户或密码错误");
        }

        List<SysPermission> sysPermissions = permissionDao.findByAdminUserId(user.getId());

        List<GrantedAuthority> authorities = new ArrayList<>();

        for (SysPermission sysPermission:
        sysPermissions) {

            if (sysPermission!=null && sysPermission.getName()!=null)
            {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(sysPermission.getName());

                authorities.add(grantedAuthority);
            }

        }

        return new User(user.getUsername(),user.getPassword(),authorities);
    }
}
