package com.fang.springboot_demo.Demo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExcUtils {


    //private static Workbook wb;
   // private static Row row;

    /**
     * 创建Workbook对象
     * @param filepath  文件路径
     */
    public  static Workbook readExcel(String filepath) {
        if(filepath==null){
            return null;
        }
        Workbook wb =null;
        //获取文件后缀
        String ext = filepath.substring(filepath.lastIndexOf("."));
        try {
            InputStream is = new FileInputStream(filepath);
            //office2003以下版本
            if(".xls".equals(ext)){
                wb=new HSSFWorkbook(is);
            }else if(".xlsx".equals(ext)){
                //office2007以上版本
                wb = new XSSFWorkbook(is);
            }else{
                wb=null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }


    /**
     * 读取Excel数据内容
     *
     */
    public static Cell  readExcelContent(Workbook wb, int s,int r , int c) throws Exception{
        if(wb==null){
            throw new Exception("Workbook对象为空！");
        }

        return wb.getSheetAt(s-1).getRow(r-1).getCell(c-1);
    }


}
