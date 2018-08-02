package com.zgc.saap.base.service.impl;

import com.zgc.saap.base.dao.BaseDao;
import com.zgc.saap.base.service.BaseService;

import java.util.List;

public abstract  class BaseServiceImpl<T> implements BaseService<T> {

    public abstract BaseDao<T> baseDao();

    public T findById(int id) {
        return baseDao().findById(id);
    }

    @Override
    public List<T> findAllObj() {
        return baseDao().findAllObj();
    }

    public int add(T t) {
        return baseDao().add(t);
    }

    public int update(T t) {
        return  baseDao().update(t);
    }

    public int deleteById(int id) {
        return   baseDao().deleteById(id);
    }
}
