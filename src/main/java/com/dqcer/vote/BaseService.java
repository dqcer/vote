package com.dqcer.vote;

import java.util.List;

public interface BaseService<T> {

    List<T> findAll();

    void insert(T t);

    void update(T t);

    void deleteById(String code);

    T findById(String code);
}
