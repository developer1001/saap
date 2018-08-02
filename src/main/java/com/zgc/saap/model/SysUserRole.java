package com.zgc.saap.model;

/**
 * @program: HMSH
 * @description: 用户和角色对应关系，一个用户可以对应多个角色，一个角色可以对应多个用户
 * @author: laoyangtou
 * @create: 2018-07-06 13:22
 **/
public class SysUserRole {
    private Integer id;//id
    private Integer userId;//用户id
    private Integer roleId;//角色id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
