package com.chenyi.study.toolkit.baseinfo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class BaseModel implements Serializable {
    private static final long serialVersionUID = 6510732474478328666L;
    private Long id;
    private String createName;
    private Long createId;
    private LocalDate createTime;
    private String updateName;
    private Long updateId;
    private LocalDate updateTime;

}
