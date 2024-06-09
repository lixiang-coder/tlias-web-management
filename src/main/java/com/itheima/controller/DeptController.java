package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门管理Controller
 */
@RestController
@Slf4j
@Api(tags = "部门管理相关接口")
public class DeptController {

    @Resource
    private DeptService deptService;

    /**
     * 部门列表查询
     *
     * @return
     */
    @ApiOperation("部门列表查询")
    @GetMapping("/depts")
    public Result list() {
        log.info("查询所有部门信息");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }


    /**
     * 根据id删除部门
     *
     * @param id
     * @return
     */
    @ApiOperation("根据id删除部门")
    @DeleteMapping("/depts/{id}")
    public Result deleteById(@PathVariable Integer id) {
        log.info("根据id删除部门");
        int count = deptService.deleteById(id);
        if (count > 0) {
            return Result.success();
        }
        return Result.error("删除失败");
    }
}
