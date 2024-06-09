package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {

    // 查询所有部门的信息
    @Select("select * from tlias.dept")
    List<Dept> list();

    // 根据id删除部门
    @Delete("delete from tlias.dept where id = #{id}")
    int deleteById(Integer id);

    // 新增部门
    @Insert("insert into tlias.dept (name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void add(Dept dept);
}
