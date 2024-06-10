package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@Api(tags = "员工登录相关接口")
public class LoginController {

    @Resource
    private EmpService empService;

    /**
     * 员工登录
     *
     * @param emp
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("员工登录")
    public Result login(@RequestBody Emp emp) {
        log.info("员工登录，emp:{}", emp);
        Emp e = empService.login(emp);
        return e != null ? Result.success() : Result.error("用户名或密码错误");
    }
}

