package com.chenyi.study.ucenter.model.user;

import com.chenyi.study.toolkit.baseinfo.BaseModel;
import lombok.Data;

@Data
public class Organization extends BaseModel {
    private String organizationName;
    private String organizationCode;
    private String status;
}
