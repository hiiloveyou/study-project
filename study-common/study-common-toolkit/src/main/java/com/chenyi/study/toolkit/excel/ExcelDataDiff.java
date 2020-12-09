package com.chenyi.study.toolkit.excel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;

/**
 * @author BG344144
 * @date 2020/11/26-19:41
 * @description
 */
public class ExcelDataDiff {

    public static void main(String[] args) throws Exception {
        readExcel();
    }

    private static void readExcel() {
        final ExcelReader excelReader = ExcelUtil.getReader("file/库存初始化导入模板.xlsx", 0);

        excelReader.addHeaderAlias("仓库编码*", "warehouseCode");
        excelReader.addHeaderAlias("商品编码*", "skuCode");
        excelReader.addHeaderAlias("商品名称", "skuName");
        excelReader.addHeaderAlias("初始化库存单位*", "quantifier");
        excelReader.addHeaderAlias("初始化库存数量*", "quantity");
        excelReader.addHeaderAlias("初始化库存成本单价*", "price");
        excelReader.addHeaderAlias("初始化商品效期*", "productionDate");

        final List<Inventory> read = excelReader.readAll(Inventory.class);
        System.out.println("read = " + read);
    }
}
