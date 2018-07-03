package com.sdu.controller;

import com.sdu.entity.Collection;
import com.sdu.entity.Cutoff;
import com.sdu.entity.SchoolInfo;
import com.sdu.repository.CollectionRepository;
import com.sdu.repository.CutoffRepository;
import com.sdu.repository.SchoolInfoRepository;
import com.sdu.utils.CutoffNoBatch;
import com.sdu.utils.CutoffNoMajorOrBatch;
import com.sdu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkkkkk on 2018/7/3.
 */

@RestController
public class SchoolInfoController {

    @Autowired
    private SchoolInfoRepository schoolInfoRepository;

    @Autowired
    private CutoffRepository cutoffRepository;

    @Autowired
    private CollectionRepository collectionRepository;

    @RequestMapping("/findSchoolInfoByName")
    public Message<SchoolInfo> findSchoolInfoByName(String name){
        SchoolInfo schoolInfo = schoolInfoRepository.findSchoolInfoByName(name);
        if(schoolInfo==null){
            return new Message<>(false,"can't find the information of the school!");
        }else{
            return new Message<>(true,"",schoolInfo);
        }
    }

    @RequestMapping("/getSchoolCutoffsNoMajor")
    public List<CutoffNoMajorOrBatch> getSchoolCutoffsNoMajor(String school_name, String category, String province, String year1, String year2){
        return cutoffRepository.findCutoffsBySchool_nameAndProvinceAndCategoryAndYearBetween(school_name, category, province, year1, year2);
    }

    @RequestMapping("/getSchoolCutoffs")
    public List<List<CutoffNoBatch>> getSchoolCutoffs(String username, String school_name, String category, String province, String year1, String year2){
        List<String> majors = collectionRepository.findUsersSchool(username);
        List<List<CutoffNoBatch>> ans = new ArrayList<>();
        List<CutoffNoBatch> cutoffNoBatches;
        for(int i=0;i<majors.size();i++){
            cutoffNoBatches = cutoffRepository.findCutoffsBySchool_nameAndProvinceAndCategoryAndYearBetweenAndMajor(school_name, category, province, year1, year2, majors.get(i));
            ans.add(cutoffNoBatches);
        }
        return ans;
    }


}
