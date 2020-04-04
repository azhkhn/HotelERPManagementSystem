package com.demo.hotel.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "employee")
public class Employee implements Serializable {
    /**
     * 职工ID
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 职位Id
     */
    @Column(name = "position_id")
    private Long positionId;

    /**
     * 职工姓名
     */
    @Column(name = "`name`")
    private String name;

    /**
     * 身份证号
     */
    @Column(name = "identify")
    private String identify;

    /**
     * 手机号
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 入职时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 性别
     */
    @Column(name = "gender")
    private Integer gender;

    /**
     * 出生日期
     */
    @Column(name = "birthday")
    private Date birthday;

    private static final long serialVersionUID = -8393696374589914109L;
}