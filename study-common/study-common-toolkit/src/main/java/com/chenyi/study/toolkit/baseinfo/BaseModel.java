package com.chenyi.study.toolkit.baseinfo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class BaseModel implements Serializable {
    private Long id;
    private String createName;
    private Long createId;
    private LocalDate createTime;
    private String updateName;
    private Long updateId;
    private LocalDate updateTime;
    private Integer lockVersion;

}
