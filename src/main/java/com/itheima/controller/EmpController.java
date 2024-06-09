package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理Controller
 */
@RestController
@Slf4j
@Api(tags = "员工管理相关接口")
@RequestMapping("/emps")
public class EmpController {

    @Resource
    private EmpService empService;

    /**
     * 条件分页查询
     *
     * @param page     页码
     * @param pageSize 每页展示记录数
     * @return
     */
    @GetMapping
    @ApiOperation("条件分页查询")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        // 如果前端没有传递这两个参数，则赋默认值
        /* 现在我们借助注解来实现
        if (page == null) page = 1;
        if (pageSize == null) pageSize = 10;
        */

        //记录日志
        log.info("分页查询，参数：{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        //调用业务层分页查询功能
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        //响应
        return Result.success(pageBean);
    }


    /**
     * 批量删除员工
     *
     * @param ids
     * @return
     */
    @DeleteMapping("/{ids}")
    @ApiOperation("批量删除员工")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除员工，参数为：{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 新增员工
     *
     * @param emp
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工, emp:{}", emp);
        empService.save(emp);
        return Result.success();
    }

}
