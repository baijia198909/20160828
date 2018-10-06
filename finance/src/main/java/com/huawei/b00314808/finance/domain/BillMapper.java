package com.huawei.b00314808.finance.domain;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.*;



/**
 * 
 * @author zhangyu
 *
 */
@Mapper
public interface BillMapper {
    /**
     * 根据name 查询Bill
     * @param name
     * @return
     */
    @Select("SELECT count(*) FROM bill WHERE name = #{name}")
    int findByNameAndPass(@Param("name") String name);

    /**
     * 根据id 查询Bill
     * @param id
     * @return
     */
    @Select("SELECT * FROM bill WHERE id = #{id}")
    Bill findByNameID(@Param("id") String id);
    
    /**
     * 新增bill
     * @param 
     * @param 
     * @return 
     */
    @Insert("INSERT INTO bill(name,date,item,price,remark) VALUES(#{name},#{date},#{item},#{price},#{remark})")
    int insert(@Param("name") String name,@Param("date") Date date,@Param("item") String item,@Param("price") String price,@Param("remark") String remark);

    /**
     * 根据 id 删除 Bill
     * @param id
     */
    @Delete("DELETE FROM bill WHERE id =#{id}")
    void delete(Long id);
    /**
     * 查询 所有 Bill
     * @return
     */
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "date", column = "date"),
        @Result(property = "item", column = "item"),
        @Result(property = "price", column = "price"),
        @Result(property = "remark", column = "remark")
    })
    @Select("SELECT id,date,name,item,price,remark FROM bill WHERE name = #{name}")
    List<Bill> findAllByName(@Param("name") String name);
    
}
