package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;

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
    @Override
    public int deleteById(Integer id) {
        return deptMapper.deleteById(id);
    }

    /**
     * 新增部门
     *
     * @param dept
     * @return
     */
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
    @Override
    public void update(Dept dept) {
        // 补全部门数据
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updata(dept);
    }
}
