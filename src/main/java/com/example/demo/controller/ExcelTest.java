package com.example.demo.controller;

import java.io.IOException;

/**
 * Created by Mloong on 2018/6/7.
 */
public class ExcelTest {
    public static void main(String[] args) {
        Test test = new Test();
        try {
//            test.writeExcel07();
            test.readExcel07();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
