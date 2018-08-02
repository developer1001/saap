package com.zgc.saap.service;

import com.zgc.saap.base.service.BaseService;
import com.zgc.saap.model.SysAuth;
import com.zgc.saap.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISysAuthService extends BaseService<SysAuth> {
    List<SysAuth> getByRoleId ( List<Integer> roleIdList);

}
