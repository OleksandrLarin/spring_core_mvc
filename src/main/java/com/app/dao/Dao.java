package com.app.dao;

import java.util.List;

public interface Dao<T> {
    T findById(int id);

    List<T> findAll();

    void create(T t);

    void update(T t);

    void delete(int id);
}
