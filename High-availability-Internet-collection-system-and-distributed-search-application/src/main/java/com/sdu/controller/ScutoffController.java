package com.sdu.controller;

import com.sdu.entity.Scutoff;
import com.sdu.repository.ScutoffRepository;
import com.sdu.utils.Message;
import com.sdu.utils.ScutoffList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/18.
 */

@RestController
public class ScutoffController {

    @Autowired
    private ScutoffRepository scutoffRepository;

    @RequestMapping("/addScutoffs")
    public Message addScutoffs(@RequestBody ScutoffList scutoffList){
        List<Scutoff> scutoffs = scutoffList.getScutoffs();
        System.out.println("here " + scutoffs.size());
        for (int i = 0; i < scutoffs.size(); i++) {
            Scutoff scutoff = scutoffs.get(i);
            saveOrUpdate(scutoff);
            System.out.println(scutoff);
        }
        return new Message(true);
    }

    @RequestMapping("/searchScutoff")
    public List<Scutoff> searchScutoff(String schoolName,String province){
        return scutoffRepository.findScutoffsBySchoolAndProvince(schoolName, province);
    }

    @RequestMapping("/findSchoolLike")
    public List<String> findSchoolLike(String schoolName){
        String pattern = "%"+schoolName+"%";
        return scutoffRepository.findSchoolLike(pattern);
    }

    private void saveOrUpdate(Scutoff scutoff) {
        Scutoff pscutoff = scutoffRepository.findScutoffBySchoolAndYearAndProvinceAndCategoryAndAndBatch(
                scutoff.getSchool(),scutoff.getYear(),
                scutoff.getProvince(), scutoff.getCategory(),
                scutoff.getBatch());
        if (pscutoff == null) {
            scutoffRepository.save(scutoff);
        } else {
            String mingrade = scutoff.getMingrade();
            String avegrade = scutoff.getAvegrade();
            String maxgrade = scutoff.getMaxgrade();
            if (mingrade != null)
                pscutoff.setMingrade(mingrade);
            if (avegrade != null)
                pscutoff.setAvegrade(avegrade);
            if (maxgrade != null)
                pscutoff.setMaxgrade(maxgrade);
            scutoffRepository.save(pscutoff);
        }
    }
}
