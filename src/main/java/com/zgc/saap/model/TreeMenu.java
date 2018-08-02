package com.zgc.saap.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;

/**
 * @program: HMSH
 * @description: 树形菜单。没有提供界面的菜单修改操作，若需修改，需要到数据库手动修改
 * @author: laoyangtou
 * @create: 2018-07-16 17:11
 **/
public class TreeMenu {
    private String F_ModuleId;
    private String F_ParentId;
    private String F_EnCode;
    private String F_FullName;
    private String F_Icon;
    private String F_UrlAddress;
    private String F_Target;
    private Integer F_IsMenu;
    private Integer F_AllowExpand;
    private Integer F_IsPublic;
    private String F_AllowEdit;
    private String F_AllowDelete;
    private Integer F_SortCode;
    private Integer F_DeleteMark;
    private Integer F_EnabledMark;
    private String F_Description;
    private Timestamp F_CreateDate;
    private String F_CreateUserId;
    private String F_CreateUserName;
    private Timestamp F_ModifyDate;
    private String F_ModifyUserId;
    private String F_ModifyUserName;

    /**
     * 加上fastjosn的@JSONField(name = "XXX")的目的是阻止返回的josn数据自动将首字母小写
     * @return
     */
    @JSONField(name = "F_ModuleId")
    public String getF_ModuleId() {
        return F_ModuleId;
    }

    public void setF_ModuleId(String f_ModuleId) {
        F_ModuleId = f_ModuleId;
    }
    @JSONField(name = "F_ParentId")
    public String getF_ParentId() {
        return F_ParentId;
    }

    public void setF_ParentId(String f_ParentId) {
        F_ParentId = f_ParentId;
    }
    @JSONField(name = "F_FullName")
    public String getF_FullName() {
        return F_FullName;
    }

    public void setF_FullName(String f_FullName) {
        F_FullName = f_FullName;
    }
    @JSONField(name = "F_Icon")
    public String getF_Icon() {
        return F_Icon;
    }

    public void setF_Icon(String f_Icon) {
        F_Icon = f_Icon;
    }
    @JSONField(name = "F_UrlAddress")
    public String getF_UrlAddress() {
        return F_UrlAddress;
    }

    public void setF_UrlAddress(String f_UrlAddress) {
        F_UrlAddress = f_UrlAddress;
    }
    @JSONField(name = "F_Target")
    public String getF_Target() {
        return F_Target;
    }

    public void setF_Target(String f_Target) {
        F_Target = f_Target;
    }
    @JSONField(name = "F_IsMenu")
    public Integer getF_IsMenu() {
        return F_IsMenu;
    }

    public void setF_IsMenu(Integer f_IsMenu) {
        F_IsMenu = f_IsMenu;
    }
    @JSONField(name = "F_AllowExpand")
    public Integer getF_AllowExpand() {
        return F_AllowExpand;
    }

    public void setF_AllowExpand(Integer f_AllowExpand) {
        F_AllowExpand = f_AllowExpand;
    }
    @JSONField(name = "F_EnCode")
    public String getF_EnCode() {
        return F_EnCode;
    }

    public void setF_EnCode(String f_EnCode) {
        F_EnCode = f_EnCode;
    }
    @JSONField(name = "F_IsPublic")
    public Integer getF_IsPublic() {
        return F_IsPublic;
    }

    public void setF_IsPublic(Integer f_IsPublic) {
        F_IsPublic = f_IsPublic;
    }
    @JSONField(name = "F_AllowEdit")
    public String getF_AllowEdit() {
        return F_AllowEdit;
    }

    public void setF_AllowEdit(String f_AllowEdit) {
        F_AllowEdit = f_AllowEdit;
    }
    @JSONField(name = "F_AllowDelete")
    public String getF_AllowDelete() {
        return F_AllowDelete;
    }

    public void setF_AllowDelete(String f_AllowDelete) {
        F_AllowDelete = f_AllowDelete;
    }
    @JSONField(name = "F_SortCode")
    public Integer getF_SortCode() {
        return F_SortCode;
    }

    public void setF_SortCode(Integer f_SortCode) {
        F_SortCode = f_SortCode;
    }
    @JSONField(name = "F_DeleteMark")
    public Integer getF_DeleteMark() {
        return F_DeleteMark;
    }

    public void setF_DeleteMark(Integer f_DeleteMark) {
        F_DeleteMark = f_DeleteMark;
    }
    @JSONField(name = "F_EnabledMark")
    public Integer getF_EnabledMark() {
        return F_EnabledMark;
    }

    public void setF_EnabledMark(Integer f_EnabledMark) {
        F_EnabledMark = f_EnabledMark;
    }
    @JSONField(name = "F_Description")
    public String getF_Description() {
        return F_Description;
    }

    public void setF_Description(String f_Description) {
        F_Description = f_Description;
    }
    @JSONField(name = "F_CreateDate")
    public Timestamp getF_CreateDate() {
        return F_CreateDate;
    }

    public void setF_CreateDate(Timestamp f_CreateDate) {
        F_CreateDate = f_CreateDate;
    }
    @JSONField(name = "F_CreateUserId")
    public String getF_CreateUserId() {
        return F_CreateUserId;
    }

    public void setF_CreateUserId(String f_CreateUserId) {
        F_CreateUserId = f_CreateUserId;
    }
    @JSONField(name = "F_CreateUserName")
    public String getF_CreateUserName() {
        return F_CreateUserName;
    }

    public void setF_CreateUserName(String f_CreateUserName) {
        F_CreateUserName = f_CreateUserName;
    }
    @JSONField(name = "F_ModifyDate")
    public Timestamp getF_ModifyDate() {
        return F_ModifyDate;
    }

    public void setF_ModifyDate(Timestamp f_ModifyDate) {
        F_ModifyDate = f_ModifyDate;
    }
    @JSONField(name = "F_ModifyUserId")
    public String getF_ModifyUserId() {
        return F_ModifyUserId;
    }

    public void setF_ModifyUserId(String f_ModifyUserId) {
        F_ModifyUserId = f_ModifyUserId;
    }
    @JSONField(name = "F_ModifyUserName")
    public String getF_ModifyUserName() {
        return F_ModifyUserName;
    }

    public void setF_ModifyUserName(String f_ModifyUserName) {
        F_ModifyUserName = f_ModifyUserName;
    }
}
