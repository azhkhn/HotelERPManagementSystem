package com.demo.hotel.business.feign;

import com.demo.hotel.business.dto.DepartmentDTO;
import com.demo.hotel.business.dto.EmployeeDTO;
import com.demo.hotel.business.dto.param.DepartmentParam;
import com.demo.hotel.business.dto.param.EmployeeParam;
import com.demo.hotel.business.feign.fallback.DepartmentFeignFallback;
import com.demo.hotel.business.feign.fallback.EmployeeFeignFallback;
import com.demo.hotel.configuration.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @program: HotelERPManagementSystem
 * @description: 职工Feign
 * @author: syj
 * @create: 2020-04-03 16:04
 **/

//value指向服务名，application
//path对应controller中的ResquestMapping
//feign类似于http客户端
//configuration = FeignRequestConfiguration.class是为了配置拦截器在请求头中加token
@FeignClient(value = "business-organization", path = "organization/employee", configuration = FeignRequestConfiguration.class, fallback = EmployeeFeignFallback.class)
public interface EmployeeFeign extends BaseFeign<EmployeeParam,EmployeeDTO> {

}
