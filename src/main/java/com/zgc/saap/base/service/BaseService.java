package com.zgc.saap.base.service;

import java.util.List;

public interface BaseService<T> {
    T findById(int id);

    List<T> findAllObj();

    int add(T t);

    int update(T t);

    int deleteById(int id);
}
