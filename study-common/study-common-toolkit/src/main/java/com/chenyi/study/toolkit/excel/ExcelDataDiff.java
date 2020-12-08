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

    public static void main(String[] args) {
        final ExcelReader excelReader = ExcelUtil.getReader(
                "C:\\Users\\bg344144\\Desktop\\版本开发\\单品库Saas化\\版本分析文件\\店群商品合同商品.xlsx",1);

        final List<List<Object>> read = excelReader.read();
    }
}
