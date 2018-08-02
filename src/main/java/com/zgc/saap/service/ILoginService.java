package com.zgc.saap.service;

import com.zgc.saap.base.service.BaseService;
import com.zgc.saap.model.SysUser;

public interface ILoginService extends BaseService<SysUser>{
    /**
     * 登录验证
     * @param loginName
     * @param password
     * @return
     */
    SysUser login(String loginName, String password);
}
