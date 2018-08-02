package com.zgc.saap.model;

/**
 * @program: HMSH
 * @description: 用户和部门关联，用户和部门是多对多关系，即一个用户可以对应多个部门，虽然听起来扯吧，但是被要求这么做。
 * @author: laoyangtou
 * @create: 2018-07-06 13:30
 **/
public class SysUserDept {
    private Integer id;//id
    private Integer userId;//用户ID
    private Integer deptId;//部门ID

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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
