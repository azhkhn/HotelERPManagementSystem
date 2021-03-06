package com.demo.hotel.provider.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.demo.hotel.provider.doamin.ViewDomain;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "shift_type_d")
public class ShiftTypeD implements ViewDomain {

    private static final long serialVersionUID = 3302393509732287548L;
    /**
     * 分类ID
     */
    @Column(name = "id")
    private Long id;

    /**
     * 分类名
     */
    @Column(name = "type_name")
    private String typeName;

    /**
     * 部门ID
     */
    @Column(name = "department_id")
    private Long departmentId;

    /**
     * 部门名
     */
    @Column(name = "department_name")
    private String departmentName;

}