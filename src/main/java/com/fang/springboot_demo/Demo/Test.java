package com.fang.springboot_demo.Demo;

import org.apache.poi.ss.usermodel.Workbook;

public class Test {

    public static void main(String args[]) throws Exception {

       Workbook wb=ReadExcUtils.readExcel("/Users/haijuan/Documents/yuliangfang/workspace/myTest/SpringBoot/src/main/java/com/fang/springboot_demo/Demo/test.xlsx");

       String c=ReadExcUtils.readExcelContent(wb,2,2,2).toString();

       System.out.println(c);

    }

}
