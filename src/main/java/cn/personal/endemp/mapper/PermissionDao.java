package cn.personal.endemp.mapper;

import cn.personal.endemp.entity.SysPermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

    @Select("SELECT * FROM sys_permission")
    public List<SysPermission> findAll();

    @Select("SELECT sp.* \n" +
            "FROM sys_user su\n" +
            "LEFT JOIN  sys_role_user sru on su.id = sru.sys_user_id\n" +
            "LEFT JOIN  sys_role sr on sr.id = sru.sys_role_id\n" +
            "LEFT JOIN  sys_permission_role spr on spr.sys_role_id = sr.id\n" +
            "LEFT JOIN  sys_permission sp on sp.id = spr.permission_id\n" +
            "WHERE su.id=#{userId}")
    public List<SysPermission> findByAdminUserId(@Param("userId") int userId);

}
