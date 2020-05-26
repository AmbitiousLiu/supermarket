package com.example.supermarket.ljy.mapper

import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Update

/**
 * @author jleo
 * @date 2020/5/26
 */
@Mapper
interface ModifyEmployeeMapper {

    @Delete("delete from employee where \${tiaojian} = #{tiaojianzhi}")
    Integer delete(@Param("tiaojian")String tiaojian,@Param("tiaojianzhi") String tiaojianzhi)

    @Update("update employee set \${gaixinxi} = #{xiugaizhi} where \${tiaojian} = #{tiaojianzhi}")
    Integer update( @Param("tiaojian")String tiaojian, @Param("tiaojianzhi") String tiaojianzhi, @Param("gaixinxi") String gaixinxi,@Param("xiugaizhi") String xiugaizhi)

}