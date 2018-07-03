package com.sdu.repository;

import com.sdu.entity.ExpectMajor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/3.
 */
public interface ExpectMajorRepository extends JpaRepository<ExpectMajor, Integer> {

    @Query("select major from ExpectMajor e where e.username = ?1")
    List<String> findUsersMajor(String username);

}
