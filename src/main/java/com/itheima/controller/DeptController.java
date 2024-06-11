package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门管理Controller
 */
@RestController
@Slf4j
@Api(tags = "部门管理相关接口")
@RequestMapping("/depts")
public class DeptController {

    @Resource
    private DeptService deptService;

    /**
     * 部门列表查询
     *
     * @return
     */
    @ApiOperation("部门列表查询")
    @GetMapping
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
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        log.info("根据id删除部门");
        int count = deptService.deleteById(id);
        if (count > 0) {
            return Result.success();
        }
        return Result.error("删除失败");
    }

    /**
     * 新增部门
     *
     * @param dept
     * @return
     */
    @ApiOperation("新增部门")
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门");
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id获取部门信息
     *
     * @param id
     * @return
     */
    @ApiOperation("根据id获取部门信息")
    @GetMapping("/{id}")
    public Result getByID(@PathVariable Integer id) {
        log.info("获取部门ID:{}", id);
        Dept dept = deptService.getByID(id);
        return Result.success(dept);
    }

    /**
     * 修改部门信息
     *
     * @param dept
     * @return
     */
    @ApiOperation("修改部门信息")
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门:{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
