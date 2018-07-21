package com.sdu.repository;

import com.sdu.entity.Scutoff;
import com.sdu.entity.ScutoffKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/18.
 */
public interface ScutoffRepository extends JpaRepository<Scutoff, ScutoffKey>{

    Scutoff findScutoffBySchoolAndYearAndProvinceAndCategoryAndAndBatch(String school, String year, String province, String category, String batch);

    @Query("select distinct school from Scutoff s where s.school like ?1")
    List<String> findSchoolLike(String schoolName);

    List<Scutoff> findScutoffsBySchoolAndProvince(String school, String province);
}
