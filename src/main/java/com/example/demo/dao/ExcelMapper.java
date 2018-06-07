package com.example.demo.dao;

import com.example.demo.bean.Hero;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Mloong on 2018/6/7.
 */
@Mapper
@Component
public interface ExcelMapper {
    /**
     * 批量导入数据
     * @param list
     */
    void batchInsert(List<Hero> list);
}
