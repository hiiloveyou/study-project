package com.chenyi.study.toolkit.studyexcel;

import lombok.Data;

/**
 * @author chenyi65536@163.com
 * @date 2020/12/8-20:15
 * @description
 */
@Data
public class Inventory {
    private String warehouseCode;
    private String skuCode;
    private String skuName;
    private String quantifier;
    private String quantity;
    private String price;
    private String productionDate;
}
