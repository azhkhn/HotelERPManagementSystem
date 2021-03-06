package com.demo.hotel.business.feign.fallback;

import com.demo.hotel.business.dto.TrainingDTO;
import com.demo.hotel.business.dto.param.TrainingParam;
import com.demo.hotel.business.feign.TrainingFeign;
import com.demo.hotel.commons.dto.CodeStatus;
import org.springframework.stereotype.Component;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-04-07 07:48
 **/
@Component
public class TrainingFeignFallback  implements TrainingFeign {

    CommonsFeignFallback<Void> cf=new CommonsFeignFallback<>();

    @Override
    public String info() {
        return cf.message();
    }

    @Override
    public String add(TrainingParam trainingParam) {
        return cf.message();
    }

    @Override
    public String delete(TrainingDTO trainingDTO) {
        return cf.message();
    }

    @Override
    public String update(TrainingDTO trainingDTO) {
        return cf.message();
    }
}
