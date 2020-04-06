package com.demo.hotel.provider.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
 * @author syj
 */
@Data
@Table(name = "training")
public class Training implements Serializable {

    private static final long serialVersionUID = 971167139468031598L;
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    @Column(name = "employee_id")
    private Long employeeId;

    /**
     * 培训内容ID
     */
    @Column(name = "training_content_id")
    private Long trainingContentId;

    /**
     * 开始时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 状态，0是未开始，1是已开始，2是培训结束
     */
    @Column(name = "`status`")
    private Integer status;

}