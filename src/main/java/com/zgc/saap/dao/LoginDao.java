package com.zgc.saap.dao;

import com.zgc.saap.base.dao.BaseDao;
import com.zgc.saap.model.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface LoginDao extends BaseDao<SysUser>{
    /**
     * 登录验证
     * @param loginName
     * @param password
     * @return
     */
    SysUser login(@Param("loginName") String loginName, @Param("password") String password);
}
