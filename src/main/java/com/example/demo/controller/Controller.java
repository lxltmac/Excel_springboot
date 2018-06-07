package com.example.demo.controller;

import com.example.demo.bean.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Mloong on 2018/6/7.
 */
@RestController
public class Controller {
    @Autowired
//    private ExcelService excelService;
    private Test test;

//    File file = new File("C:\\Users\\Mloong\\Desktop\\test.xlsx");
    File file = new File("d:\\poi\\测试.xlsx");

    @RequestMapping("/")
    public String hell(){
        return "hell world";
    }
    @RequestMapping("/file")
    public List<Hero> downloadFile() throws IOException {
//        file = new File("C:\\Users\\Mloong\\Desktop\\test.xlsx");
//        List<Hero> heroList =  excelService.importData(file);
//        for(int i = 0;i<heroList.size();i++){
//            System.out.println(heroList.get(i));
//        }
//        Test test = new Test();
        String value = null;
        List<Hero> list = test.readExcel07();
//        for(Hero i:list) {
//            value = i;
////            return value;
//        }
        return list;
    }
}

