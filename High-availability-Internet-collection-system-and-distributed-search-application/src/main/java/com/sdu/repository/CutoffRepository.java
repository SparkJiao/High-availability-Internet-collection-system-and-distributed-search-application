package com.sdu.repository;

import com.sdu.entity.Cutoff;
import com.sdu.entity.CutoffKey;
import com.sdu.utils.CutoffNoBatch;
import com.sdu.utils.CutoffNoMajor;
import com.sdu.utils.CutoffNoMajorOrBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/2.
 */

/*
1、全局查询
2、指定学校、省份、文理分科和起始终止年份（可默认）
    a、指定专业
    b、指定批次？
 */

public interface CutoffRepository extends JpaRepository<Cutoff, CutoffKey>{

    //Cutoff findBySchool_nameAndProvinceAndYearAndCategoryAndMajorAndBatch(String school_name, String province, String year, String category, String major, String batch);

    @Query("select schoolName, province, year, category, avegrade, maxgrade, min(mingrade) from Cutoff c where (c.schoolName = ?1 and c.province = ?2 and c.category = ?3 and c.year>= ?4 and c.year <= ?5) group by year order by year")
    List<CutoffNoMajorOrBatch> findCutoffsBySchoolNameAndProvinceAndCategoryAndYearBetween(String school_name, String province, String category, String year1, String year2);

    @Query("select schoolName, province, year, category, major, avegrade, maxgrade, min(mingrade) from Cutoff c where (c.schoolName = ?1 and c.province = ?2 and c.category = ?3 and c.year>=?4 and c.year <= ?5 and c.major = ?6) group by year order by year")
    List<CutoffNoBatch> findCutoffsBySchoolNameAndProvinceAndCategoryAndYearBetweenAndMajor(String school_name, String province, String category, String year1, String year2, String major);

    @Query("select schoolName, province, year, category, batch, avegrade, maxgrade, min(mingrade) from Cutoff c where (c.schoolName = ?1 and c.province = ?2 and c.category = ?3 and c.year>=?4 and c.year <= ?5 and c.batch = ?6) group by year order by year")
    List<CutoffNoMajor> findCutoffsBySchoolNameAndProvinceAndCategoryAndYearBetweenAndBatch(String school_name, String province, String category, String year1, String year2, String batch);

    @Query("select schoolName, province, year, category, major, batch, avegrade, maxgrade, mingrade from Cutoff c where (c.schoolName = ?1 and c.province = ?2 and c.category = ?3 and c.year>= ?4 and c.year <= ?5 and c.major = ?6 and c.batch = ?7) order by year")
    List<Cutoff> findCutoffsBySchoolNameAndProvinceAndCategoryAndYearBetweenAndMajorAndBatch(String school_name, String province, String category, String year1, String year2, String major, String batch);

    Cutoff findCutoffBySchoolNameAndProvinceAndYearAndCategoryAndMajorAndBatch(String schoolName, String province, String year, String category, String major, String batch);

    List<Cutoff> findCutoffsBySchoolNameAndProvinceAndMajorContains(String schoolName, String province, String major);

    //List<Cutoff> findCutoffsBySchoolNameAndMajorContains(String schoolName, String major);
}
