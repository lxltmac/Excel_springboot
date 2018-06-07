package com.example.demo.service.Impl;

import com.example.demo.Util.ExcelUtil;
import com.example.demo.bean.Hero;
import com.example.demo.dao.ExcelMapper;
import com.example.demo.service.ExcelService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mloong on 2018/6/7.
 */
@Service
public class ExcelServiceImpl implements ExcelService{
    @Autowired
    private ExcelMapper excelMapper;
    @Override
    public List<Hero> importData(File file) {
        Workbook wb = null;
        List<Hero> heroList = new ArrayList<>();
        try{
            if(ExcelUtil.isExcel2007(file.getPath())){
                wb = new XSSFWorkbook(new FileInputStream(file));
            }
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
        Sheet sheet = wb.getSheetAt(0);//获取第一张表
        for(int i=0;i<sheet.getLastRowNum();i++){
            Row row = sheet.getRow(i);//获取索引为i的行，以0开始
            String name = row.getCell(0).getStringCellValue();//获取第i行的索引为0的单元格数据
            int age = (int) row.getCell(1).getNumericCellValue();
            if(age== 0 && name == null){
                break;
            }
            Hero hero = new Hero();
            hero.setName(name);
            hero.setAge(age);
            heroList.add(hero);
        }
        try{
            wb.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        excelMapper.batchInsert(heroList);
        return heroList;
    }
}
