package com.sdu.controller;

import com.sdu.entity.School;
import com.sdu.repository.SchoolRepository;
import com.sdu.utils.StringProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kkkkkk on 2018/7/24.
 */

@RestController
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @RequestMapping("/findSchoolsLike")
    public Set<String> findSchoolsLike(String school){
        List<School> list = schoolRepository.findSchoolsBySchoolContains(school);
        Set<String> set =new HashSet<>();
        for(int i=0;i<list.size();i++){
            set.add(StringProcess.deleteBlankSpace(list.get(i).getSchool()));
        }
        return set;
    }
}
