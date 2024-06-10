package com.itheima.mapper;

import com.itheima.pojo.Emp;
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
}
