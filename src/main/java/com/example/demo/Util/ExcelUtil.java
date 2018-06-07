package com.example.demo.Util;

/**
 * Created by Mloong on 2018/6/7.
 */
public class ExcelUtil {
    public static boolean isExcel2003(String filePath){
        return filePath.matches("^.+\\\\.(?i)(xls)$");
    }
    public static boolean isExcel2007(String filePath){
        return filePath.matches("^.+\\\\.(?i)(xlsx)$");
    }
}
