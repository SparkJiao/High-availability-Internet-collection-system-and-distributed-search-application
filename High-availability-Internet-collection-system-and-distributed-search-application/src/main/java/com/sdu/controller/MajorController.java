package com.sdu.controller;

import com.sdu.entity.Major;
import com.sdu.repository.MajorRepository;
import com.sdu.utils.StringProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by kkkkkk on 2018/7/23.
 */

@RestController
public class MajorController {

    @Autowired
    private MajorRepository majorRepository;

    @RequestMapping("/findMajorContains")
    public Set<String> findMajorsByMajorContains(String major){
        List<Major> list = majorRepository.findMajorsByMajorContains(major);
        Set<String> set = new HashSet<>();
        for(int i=0;i<list.size();i++){
            set.add(StringProcess.deleteBlankSpace(list.get(i).getMajor()));
        }
        return set;
    }
}
