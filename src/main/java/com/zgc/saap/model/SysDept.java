package com.zgc.saap.model;

public class SysDept {
    /**
     * 部门ID
     */
    private Integer id;
    /**
     * 部门名称
     */
    private String dept_name;
    /**
     * 部门编码
     */
    private String dept_code;
    /**
     * 上级部门编码
     */
    private String pid;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDept_name() {
        return dept_name;
    }
    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
    public String getDept_code() {
        return dept_code;
    }
    public void setDept_code(String dept_code) {
        this.dept_code = dept_code;
    }
    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
}
