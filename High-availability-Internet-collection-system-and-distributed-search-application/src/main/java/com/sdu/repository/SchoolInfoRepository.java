package com.sdu.repository;

import com.sdu.entity.SchoolInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kkkkkk on 2018/7/2.
 */
public interface SchoolInfoRepository extends JpaRepository<SchoolInfo, String> {

    SchoolInfo findSchoolInfoByName(String name);

}
