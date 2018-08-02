package com.zgc.saap.model;

/**
 * @program: HMSH
 * @description: 角色和权限相关联，多对多关系，一个角色拥有多个菜单的权限，一个菜单的权限可以分配给多个角色
 * @author: laoyangtou
 * @create: 2018-07-06 13:42
 **/
public class SysRoleAuth {
    private Integer id;//id
    private Integer roleId;//角色ID
    private Integer authId;//菜单ID

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }
}
