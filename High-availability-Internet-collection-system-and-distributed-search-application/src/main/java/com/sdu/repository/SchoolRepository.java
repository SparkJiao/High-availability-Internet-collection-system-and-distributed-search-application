package com.sdu.repository;

import com.sdu.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/24.
 */
public interface SchoolRepository extends JpaRepository<School, String>{

    List<School> findSchoolsBySchoolContains(String school);
}
