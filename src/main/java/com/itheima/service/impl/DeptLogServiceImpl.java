package com.itheima.service.impl;

import com.itheima.mapper.DeptLogMapper;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
public class DeptLogServiceImpl implements DeptLogService {
    @Resource
    private DeptLogMapper deptLogMapper;

    /**
     * 向部门日志中插入信息
     *
     * @param deptLog
     */
    //事务传播行为默认：有事务就加入、没有事务就新建事务
    @Transactional(propagation = Propagation.REQUIRES_NEW)  //事务传播行为：不论是否有事务，都新建事务
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}