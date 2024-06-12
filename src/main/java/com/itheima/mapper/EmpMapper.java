package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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


    /**
     * 批量删除员工
     *
     * @param ids
     */
    void delete(List<Integer> ids);


    /**
     * 新增员工
     *
     * @param emp
     */
    @Insert("insert into tlias.emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    void save(Emp emp);


    /**
     * 根据id查询员工
     *
     * @param id
     * @return
     */
    @Select("select * from tlias.emp where id = #{id}")
    Emp getById(Integer id);


    /**
     * 修改员工信息
     *
     * @param emp
     */
    void update(Emp emp);


    /**
     * 员工登录
     *
     * @param emp
     * @return
     */
    @Select("select * from tlias.emp where username = #{username} and password = #{password};")
    Emp getByUsernameAndPassword(Emp emp);


    /**
     * 根据部门id删除部门下所有员工
     *
     * @param deptId
     */
    @Delete("delete from tlias.emp where dept_id = #{deptId}")
    void deldeleteByDeptId(Integer deptId);
}
