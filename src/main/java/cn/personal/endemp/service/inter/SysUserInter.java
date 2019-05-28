package cn.personal.endemp.service.inter;

import cn.personal.endemp.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysUserInter {

    public List<SysUser> getSysUser();

    public SysUser checkLogin(String username);

}
