package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

    // 查询员工总数
    /*@Select("select count(*) from tlias.emp;")
    Long count();

    // 获取当前页的结果列表
    @Select("select * from tlias.emp limit #{start}, #{pageSize};")
    List<Emp> list(Integer start, Integer pageSize);*/

    // 获取当前页的结果列表
    // 大坑：最好不要在mapper接口中使用方法重载
    //@Select("select * from tlias.emp")
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
}
