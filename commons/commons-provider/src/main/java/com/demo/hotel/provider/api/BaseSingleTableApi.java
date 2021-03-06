package com.demo.hotel.provider.api;

import com.demo.hotel.provider.doamin.ViewDomain;

/**
 * @program: HotelERPManagementSystem
 * @description: 单表Api
 * @author: syj
 * @create: 2020-04-24 12:15
 **/
public interface BaseSingleTableApi<T> extends BaseViewApi<T>, BaseTableApi<T> {
}
