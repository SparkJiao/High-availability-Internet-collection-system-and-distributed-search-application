package com.sdu.repository;

import com.sdu.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/23.
 */
public interface MajorRepository extends JpaRepository<Major, String>{

   List<Major> findMajorsByMajorContains(String major);
}
