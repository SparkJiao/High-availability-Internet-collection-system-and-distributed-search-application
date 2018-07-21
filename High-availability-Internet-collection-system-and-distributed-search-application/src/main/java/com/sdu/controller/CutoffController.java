package com.sdu.controller;

import com.sdu.entity.Cutoff;
import com.sdu.entity.CutoffKey;
import com.sdu.entity.Pcutoff;
import com.sdu.repository.CutoffRepository;
import com.sdu.repository.PcutoffRepository;
import com.sdu.repository.ScutoffRepository;
import com.sdu.utils.CutoffList;
import com.sdu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by kkkkkk on 2018/7/2.
 */

@RestController
public class CutoffController {

    @Autowired
    private CutoffRepository cutoffRepository;

    @Autowired
    private ScutoffRepository scutoffRepository;

    @Autowired
    private PcutoffRepository pcutoffRepository;

    @RequestMapping(value = "/saveCutoff")
    public Message save(@RequestBody Cutoff cutoff) {
        //System.out.println("here" + school_name + " " + batch);
        //Cutoff cutoff = new Cutoff(school_name, province, year, category, major, batch, avegrade, maxgrade, mingrade);
        System.out.println(cutoff.getSchoolName() + cutoff.getProvince());
        cutoffRepository.save(cutoff);
        Message message = new Message(true);
        return message;
    }

    @RequestMapping("/addCutoff")
    public Message addCutoff(@RequestBody CutoffList cutoffList) {
        //List<CutoffModel> cutoffs = cutoffList.getCutoffModels();
        List<Cutoff> cutoffs = cutoffList.getCutoffs();
        System.out.println("here " + cutoffs.size());
        for (int i = 0; i < cutoffs.size(); i++) {
            Cutoff cutoff = cutoffs.get(i);
            saveOrUpdate(cutoff);
            System.out.println(cutoff);
        }
        return new Message(true);
    }

    @RequestMapping("/findCutoffs")
    public List findCutoffs(String school_name, String province, String year1, String year2, String category, String major, String batch) {
        //学校省份文理分科必填
        //起始年份终止年份、专业、批次可以采用默认值 默认值：起始年份：0 终止年份：2020 专业："default"
        //默认传-1即不限定批次，0-提前批，1-本科一批，2-本科二批，3-本科三批， 4-专科， 5-本科"
        if (batch.equals("-1") && major.equals("default")) {
            return cutoffRepository.findCutoffsBySchoolNameAndProvinceAndCategoryAndYearBetween(school_name, province, category, year1, year2);
        } else if (batch.equals("-1")) {
            return cutoffRepository.findCutoffsBySchoolNameAndProvinceAndCategoryAndYearBetweenAndMajor(school_name, province, category, year1, year2, major);
        } else if (major.equals("default")) {
            return cutoffRepository.findCutoffsBySchoolNameAndProvinceAndCategoryAndYearBetweenAndBatch(school_name, province, category, year1, year2, batch);
        } else {
            return cutoffRepository.findCutoffsBySchoolNameAndProvinceAndCategoryAndYearBetweenAndMajorAndBatch(school_name, province, category, year1, year2, major, batch);
        }
    }

    @RequestMapping("/searchCutoff")
    public List<Cutoff> searchCutoff(String school_name, String province, String major){
        System.out.println(school_name + " " + province + " " + major);
        List<Cutoff> cutoffs = cutoffRepository.findCutoffsBySchoolNameAndProvinceAndMajor(school_name, province, major);
        System.out.println(cutoffs.size());
        return cutoffs;
    }


    private void saveOrUpdate(Cutoff cutoff) {
        Cutoff ncutoff = cutoffRepository.findCutoffBySchoolNameAndProvinceAndYearAndCategoryAndMajorAndBatch(
                cutoff.getSchoolName(), cutoff.getProvince(),
                cutoff.getYear(), cutoff.getCategory(),
                cutoff.getMajor(), cutoff.getBatch());
        if (ncutoff == null) {
            cutoffRepository.save(cutoff);
        } else {
            String mingrade = cutoff.getMingrade();
            String avegrade = cutoff.getAvegrade();
            String maxgrade = cutoff.getMaxgrade();
            if (mingrade != null)
                ncutoff.setMingrade(mingrade);
            if (avegrade != null)
                ncutoff.setAvegrade(avegrade);
            if (maxgrade != null)
                ncutoff.setMaxgrade(maxgrade);
            cutoffRepository.save(ncutoff);
        }
    }
}
