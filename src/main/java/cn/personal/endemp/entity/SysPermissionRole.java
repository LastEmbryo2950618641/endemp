package cn.personal.endemp.entity;

public class SysPermissionRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission_role.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission_role.sys_role_id
     *
     * @mbggenerated
     */
    private Integer sysRoleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission_role.permission_id
     *
     * @mbggenerated
     */
    private Integer permissionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission_role.id
     *
     * @return the value of sys_permission_role.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission_role.id
     *
     * @param id the value for sys_permission_role.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission_role.sys_role_id
     *
     * @return the value of sys_permission_role.sys_role_id
     *
     * @mbggenerated
     */
    public Integer getSysRoleId() {
        return sysRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission_role.sys_role_id
     *
     * @param sysRoleId the value for sys_permission_role.sys_role_id
     *
     * @mbggenerated
     */
    public void setSysRoleId(Integer sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission_role.permission_id
     *
     * @return the value of sys_permission_role.permission_id
     *
     * @mbggenerated
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission_role.permission_id
     *
     * @param permissionId the value for sys_permission_role.permission_id
     *
     * @mbggenerated
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}