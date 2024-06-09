package com.itheima.service;

import com.itheima.pojo.PageBean;

/**
 * 员工管理
 */
public interface EmpService {
    PageBean page(Integer page, Integer pageSize);
}
