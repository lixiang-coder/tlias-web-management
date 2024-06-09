package com.itheima.controller;

import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        // 如果前端没有传递这两个参数，则赋默认值
        /* 现在我们借助注解来实现
        if (page == null) page = 1;
        if (pageSize == null) pageSize = 10;
        */

        //记录日志
        log.info("分页查询，参数：{},{}", page, pageSize);
        //调用业务层分页查询功能
        PageBean pageBean = empService.page(page, pageSize);
        //响应
        return Result.success(pageBean);
    }

}
