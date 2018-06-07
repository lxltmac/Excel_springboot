package com.example.demo.service;

import com.example.demo.bean.Hero;

import java.io.File;
import java.util.List;

/**
 * Created by Mloong on 2018/6/7.
 */
public interface ExcelService {
    public List<Hero> importData(File file);
}
