package com.zgc.saap.service.impl;

import com.zgc.saap.base.dao.BaseDao;
import com.zgc.saap.base.service.impl.BaseServiceImpl;
import com.zgc.saap.dao.TreeMenuDao;
import com.zgc.saap.model.TreeMenu;
import com.zgc.saap.service.ITreeMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: HMSH
 * @description: 树形菜单
 * @author: laoyangtou
 * @create: 2018-07-16 17:35
 **/
@Service
public class TreeMenuServiceImpl extends BaseServiceImpl<TreeMenu> implements ITreeMenuService {

    @Autowired
    TreeMenuDao treeMenuDao;

    @Override
    public BaseDao<TreeMenu> baseDao() {
        return treeMenuDao;
    }
}
