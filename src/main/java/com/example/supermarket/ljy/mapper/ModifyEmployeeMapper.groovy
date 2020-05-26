package com.example.supermarket.ljy.mapper

import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Update

/**
 * @author jleo
 * @date 2020/5/26
 */
@Mapper
interface ModifyEmployeeMapper {

    @Delete("delete from employee where #{tiaojian} = #{tiaojianzhi}")
    Integer delete(String tiaojian, String tiaojianzhi)

    @Update("update employee set #{gaixinxi} = #{xiugaizhi} where #{tiaojian} = #{tiaojianzhi}")
    Integer update(String tiaojian, String tiaojianzhi, String gaixinxi, String xiugaizhi)

}