package com.example.supermarket.ljy.service

import com.example.supermarket.ljy.mapper.ModifyEmployeeMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author jleo
 * @date 2020/5/26
 */
@Service
class ModifyEmployeeService {

    @Autowired
    ModifyEmployeeMapper modifyEmployeeMapper

    def delete(String tiaojian, String tiaojianzhi) {
        return modifyEmployeeMapper.delete(tiaojian, tiaojianzhi)
    }

    def update(String tiaojian, String tiaojianzhi, String gaixinxi, String xiugaizhi) {
        return modifyEmployeeMapper.update(tiaojian, tiaojianzhi, gaixinxi, xiugaizhi)
    }

}
