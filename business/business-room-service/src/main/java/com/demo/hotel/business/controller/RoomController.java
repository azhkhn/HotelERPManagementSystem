package com.demo.hotel.business.controller;

import com.demo.hotel.business.base.controller.BaseSingleTableController;
import com.demo.hotel.business.base.controller.BaseTableController;
import com.demo.hotel.business.dto.RoomDTO;
import com.demo.hotel.business.dto.RoomTDTO;
import com.demo.hotel.business.dto.RoomTypeDTO;
import com.demo.hotel.business.dto.param.RoomParam;
import com.demo.hotel.business.dto.param.RoomTypeParam;
import com.demo.hotel.commons.dto.CodeStatus;
import com.demo.hotel.commons.dto.ResponseResult;
import com.demo.hotel.provider.api.RoomService;
import com.demo.hotel.provider.api.RoomTService;
import com.demo.hotel.provider.api.RoomTypeService;
import com.demo.hotel.provider.domain.Room;
import com.demo.hotel.provider.domain.RoomT;
import com.demo.hotel.provider.domain.RoomType;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: HotelERPManagementSystem
 * @description: 房间控制器
 * @author: syj
 * @create: 2020-04-03 16:52
 **/
@RequestMapping(value = "room/content")
@RestController
public class RoomController {

    @Reference(version = "1.0.0")
    RoomService service;

    @Reference(version = "1.0.0")
    RoomTService vService;

    @Reference(version = "1.0.0")
    RoomTypeService roomTypeService;

    BaseTableController<RoomService, RoomTService,RoomDTO, RoomTDTO,Room, RoomT,RoomParam> bt=new BaseTableController();
    /**
     * 获取信息
     *
     * @return
     */
    @GetMapping(value = "info")
    public ResponseResult<List<RoomTDTO>> info() {
        return bt.info(vService, new RoomTDTO());
    }

    /**
     * 获取房间信息
     * @return
     */
    @GetMapping(value = "infoRoom")
    public ResponseResult<List<RoomDTO>> infoRoom() {
        List<Room> rooms = service.selectAllRoom();

        List<RoomDTO> vDTO = new ArrayList<>();
        rooms.forEach(v -> {
            RoomDTO d = new RoomDTO();
            BeanUtils.copyProperties(v, d);
            vDTO.add(d);
        });

        return new ResponseResult<>(CodeStatus.OK, "获取信息成功", vDTO);
    }

    /**
     * 添加信息
     *
     * @param param
     * @return
     */
    @PostMapping(value = "add")
    public ResponseResult<Void> add(@RequestBody RoomParam param) {
        Room room =new Room();
        room.setStatus(2);

        RoomType roomType = roomTypeService.getById(param.getTypeId());
        roomType.setRoomCount(roomType.getRoomCount()+1);
        roomTypeService.update(roomType);
        return bt.add(service, room, param);
    }

    /**
     * 更新信息
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "update")
    public ResponseResult<Void> update(@RequestBody RoomDTO dTO) {
        Room room =new Room();
        return bt.update(service, room, dTO);
    }

    /**
     * 删除信息
     *
     * @param dTO
     * @return
     */
    @PostMapping(value = "delete")
    public ResponseResult<Void> delete(@RequestBody RoomDTO dTO) {
        Long id = dTO.getId();
        return bt.delete(service, id);
    }
}
