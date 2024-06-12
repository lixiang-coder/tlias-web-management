package com.itheima.service.impl;

import com.itheima.anno.Log;
import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptLogService;
import com.itheima.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;

    @Resource
    private EmpMapper empMapper;

    @Resource
    private DeptLogService deptLogService;

    /**
     * 部门列表查询
     *
     * @return
     */
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }


    /**
     * 根据id删除部门
     *
     * @param id
     * @return
     */
    @Log
    @Override
    @Transactional(rollbackFor = Exception.class)  //当前方法添加了事务管理,并指定所有异常都执行事物的回滚操作
    public void deleteById(Integer id) throws Exception {
        try {
            // 根据部门id删除部门
            deptMapper.deleteById(id);

            //模拟：异常发生（运行时异常）
            //int i = 1 / 0;
            /*if (true) {
                // 编译时异常，默认事物不回滚，如果回滚要指定所有异常
                throw new Exception("出现异常了~~~");
            }*/

            // 删除这个部门下所有员工的数据
            empMapper.deldeleteByDeptId(id);
        } finally {
            //不论是否有异常，最终都要执行的代码：记录日志
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作，此时解散的是" + id + "号部门");
            //调用其他业务类中的方法
            deptLogService.insert(deptLog);
        }
    }


    /**
     * 新增部门
     *
     * @param dept
     * @return
     */
    @Log
    @Override
    public void add(Dept dept) {
        // 1.补全部门数据
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        // 2.调用mepper层
        deptMapper.add(dept);
    }


    /**
     * 根据id获取部门信息
     *
     * @param id
     * @return
     */
    @Override
    public Dept getByID(Integer id) {
        return deptMapper.getId(id);
    }


    /**
     * 修改部门信息
     *
     * @param dept
     */
    @Log
    @Override
    public void update(Dept dept) {
        // 补全部门数据
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updata(dept);
    }
}
