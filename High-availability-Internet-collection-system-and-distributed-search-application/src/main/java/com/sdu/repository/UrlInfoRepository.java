package com.sdu.repository;

import com.sdu.entity.UrlInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/16.
 */
public interface UrlInfoRepository extends JpaRepository<UrlInfo, String>{


    @Query("select url from UrlInfo u where u.startUrl = ?1 and u.currentLevel = ?2")
    List<String> findUrlsByStartUrlAndCurrentLevel(String startUrl, int currentLevel);
}
