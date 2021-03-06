package com.demo.hotel.business.dto;

import lombok.Data;

/**
 * @program: HotelERPManagementSystem
 * @description:
 * @author: syj
 * @create: 2020-05-06 08:18
 **/
@Data
public class RoomTypeDTO implements TableDTO {

    private static final long serialVersionUID = -6498534988030992508L;

    /**
     * id
     */
    private Long id;

    /**
     * 类型名
     */
    private String typeName;

    /**
     * 图片
     */
    private String picture;

    /**
     * 描述
     */
    private String note;

    /**
     * 价格
     */
    private Double price;

    /**
     * 押金
     */
    private Double deposit;

    /**
     * 床位数
     */
    private Integer bedCount;

    /**
     * 房间数
     */
    private Integer roomCount;
}
