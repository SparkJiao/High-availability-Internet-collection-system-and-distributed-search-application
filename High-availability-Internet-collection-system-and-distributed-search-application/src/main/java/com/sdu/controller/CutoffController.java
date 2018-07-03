package com.sdu.controller;

import com.sdu.entity.Cutoff;
import com.sdu.repository.CutoffRepository;
import com.sdu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/2.
 */

@RestController
public class CutoffController {

    @Autowired
    private CutoffRepository cutoffRepository;

    @RequestMapping("/addCutoff")
    public Message save(String school_name, String province, String year, String category, String major, String batch, String grade) {
        Cutoff cutoff = new Cutoff(school_name, province, year, category, major, batch, grade);
        cutoffRepository.save(cutoff);
        Message message = new Message(true);
        return message;
    }

    @RequestMapping("/findCutoffs")
    public List findCutoffs(String school_name, String province, String year1, String year2, String category, String major, String batch) {
        //学校省份文理分科必填
        //起始年份终止年份、专业、批次可以采用默认值 默认值：起始年份：0 终止年份：2020 专业："default"
        //默认传-1即不限定批次，0-提前批，1-本科一批，2-本科二批，3-本科三批， 4-专科， 5-本科"
        if (batch.equals("-1") && major.equals("default")) {
            return cutoffRepository.findCutoffsBySchool_nameAndProvinceAndCategoryAndYearBetween(school_name, province, category, year1, year2);
        } else if (batch.equals("-1")) {
            return cutoffRepository.findCutoffsBySchool_nameAndProvinceAndCategoryAndYearBetweenAndMajor(school_name, province, category, year1, year2, major);
        } else if (major.equals("default")) {
            return cutoffRepository.findCutoffsBySchool_nameAndProvinceAndCategoryAndYearBetweenAndBatch(school_name, province, category, year1, year2, batch);
        } else {
            return cutoffRepository.findCutoffsBySchool_nameAndProvinceAndCategoryAndYearBetweenAndMajorAndBatch(school_name, province, category, year1, year2, major, batch);
        }
    }


}
