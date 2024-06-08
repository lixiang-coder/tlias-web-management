package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门管理Controller
 */
@RestController
@Slf4j
public class DeptController {
    @Resource
    private DeptService deptService;

    /**
     * 部门列表查询
     * @return
     */
    @GetMapping("/depts")
    public Result list(){
        log.info("查询所有部门信息");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }
}
