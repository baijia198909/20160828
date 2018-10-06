package com.huawei.b00314808.finance.domain;

import java.util.List;

import org.apache.ibatis.annotations.*;



/**
 * 
 * @author zhangyu
 *
 */
@Mapper
public interface EmployeeMapper {
    /**
     * 根据user,password 查询Employee
     * @param user,password
     * @return
     */
    @Select("SELECT count(*) FROM employee WHERE user = #{user} and password = #{password}")
    int findByNameAndPass(@Param("user") String user, @Param("password") String password);
    /**
     * 根据user 查询Employee
     * @param user
     * @return
     */
    @Select("SELECT * FROM employee WHERE user = #{user}")
    Employee findByName(@Param("user") String user);
    
    /**
     * 根据  user 和  password 注册用户
     * @param user
     * @param password
     * @return result
     */
    @Insert("INSERT INTO employee(user, password) VALUES(#{user}, #{password})")
    int insert(@Param("user") String user, @Param("password") String password);

    /**
     * 根据 id 删除 Employee
     * @param id
     */
    @Delete("DELETE FROM employee WHERE id =#{id}")
    void delete(Long id);
    /**
     * 查询 所有 Employee
     * @return
     */
    @Results({
        @Result(property = "user", column = "user"),
        @Result(property = "password", column = "password")
    })
    @Select("SELECT id,user, password FROM Employee")
    List<Employee> findAll();
}
