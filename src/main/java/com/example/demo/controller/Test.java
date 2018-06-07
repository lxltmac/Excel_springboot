package com.example.demo.controller;

import com.example.demo.bean.Hero;
import com.example.demo.dao.ExcelMapper;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mloong on 2018/6/7.
 */
@Service
public class Test {
    @Autowired
    private ExcelMapper excelMapper;
//    @Autowired
//    private ExcelService excelService;
public void writeExcel07() throws IOException {
    //创建工作簿
    XSSFWorkbook workBook = new XSSFWorkbook();
    //创建工作表
    XSSFSheet sheet = workBook.createSheet("helloWorld");
    //创建行
    XSSFRow row = sheet.createRow(2);
    //创建单元格，操作第三行第三列
    XSSFCell cell = row.createCell(2, CellType.STRING);
    cell.setCellValue("helloWorld");

    FileOutputStream outputStream = new FileOutputStream(new File("d:\\poi\\测试.xlsx"));
    workBook.write(outputStream);

    workBook.close();//记得关闭工作簿
}

    public  List<Hero> readExcel07() throws IOException{
        FileInputStream inputStream = new FileInputStream(new File("d:\\poi\\批量导入用户模板.xlsx"));
        List<Hero> list = new ArrayList<>();
        String value = null;
        //读取工作簿
        XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
        //读取工作表
        XSSFSheet sheet = workBook.getSheetAt(0);
        for(int i = 6;i <= sheet.getLastRowNum();i++){
            XSSFRow row = sheet.getRow(i);
//            System.out.println(row);
//            for(int j = 0; j<row.getLastCellNum();j++){
//                XSSFCell cell = row.getCell(j);
                String name = row.getCell(0).getStringCellValue();
                String sex = row.getCell(1).getStringCellValue();
                String type = row.getCell(2).getStringCellValue();
                String number = row.getCell(3).getStringCellValue();
                String num = row.getCell(4).getStringCellValue();
                String ningCheng = row.getCell(5).getStringCellValue();
                String wechatName = row.getCell(6).getStringCellValue();
                int age = (int) row.getCell(7).getNumericCellValue();
                String email = row.getCell(8).getStringCellValue();
                String mz = row.getCell(9).getStringCellValue();
                String company = row.getCell(10).getStringCellValue();
                String duty = row.getCell(11).getStringCellValue();
                String hang = row.getCell(12).getStringCellValue();
                String nianxian = row.getCell(13).getStringCellValue();
                String zhu = row.getCell(14).getStringCellValue();
                String nian = row.getCell(15).getStringCellValue();
                String gouci = row.getCell(16).getStringCellValue();
                String level = row.getCell(17).getStringCellValue();
//                System.out.println(value);
                Hero hero = new Hero();
                if(name !=null && !name.equals("")) {
                    hero.setName(name);
                }
                if(sex !=null && !sex.equals("")) {
                    hero.setSex(sex);
                }
                if(type !=null && !type.equals("")) {
                    hero.setType(type);
                }
                if(number !=null && !number.equals("")) {
                    hero.setNumber(number);
                }
                if(num !=null && !num.equals("")) {
                    hero.setNum(num);
                }
                if(ningCheng!=null && !ningCheng.equals("")) {
                    hero.setNingCheng(ningCheng);
                }
                if(wechatName!=null && !wechatName.equals("")) {
                    hero.setWechatName(wechatName);
                }
                if(age != 0){
                    hero.setAge(age);
                }
                if(email != null && !email.equals("")) {
                    hero.setEmail(email);
                }
                if(mz != null && !mz.equals("")) {
                    hero.setMz(mz);
                }
                if(company != null && !company.equals("")) {
                    hero.setCompany(company);
                }
                if(duty != null && !duty.equals("")) {
                    hero.setDuty(duty);
                }
                if(hang != null && !hang.equals("")) {
                    hero.setHang(hang);
                }
                if(nianxian !=null && !nianxian.equals("")) {
                    hero.setNianxian(nianxian);
                }
                if(zhu !=null && !zhu.equals("")) {
                    hero.setZhu(zhu);
                }
                if(nian !=null && !nian.equals("")) {
                    hero.setNian(nian);
                }
                if(gouci !=null && !gouci.equals("")) {
                    hero.setGouci(gouci);
                }
                if(level !=null && !level.equals("")) {
                    hero.setLevel(level);
                }
                if(hero != null || !hero.equals("")){
                    list.add(hero);
                }
//            }
        }
//        //读取行
//        XSSFRow row = sheet.getRow(2);
//        //读取单元格
//        XSSFCell cell = row.getCell(2);
//        String value = cell.getStringCellValue();
//
//        System.out.println(value);
        inputStream.close();//关闭工作簿
        workBook.close();
        excelMapper.batchInsert(list);
        return list;
    }
}
