package com.itheima.mapper;

import com.itheima.pojo.DeptLog;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DeptLogMapper {

    /**
     * 插入部门日志
     *
     * @param log
     */
    @Insert("insert into tlias.dept_log(create_time,description) values(#{createTime},#{description})")
    void insert(DeptLog log);
}