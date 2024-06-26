package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {

    List<Dept> list();

    void deleteById(Integer id) throws Exception;

    void add(Dept dept);

    Dept getByID(Integer id);

    void update(Dept dept);
}
