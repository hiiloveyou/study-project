package com.chenyi.study.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserVO {

    @NotBlank
    private String userName;

}
