package com.sdu.repository;

import com.sdu.entity.Model;
import com.sdu.utils.MatchModel;
import com.sdu.utils.MatchView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/16.
 */
public interface ModelRepository extends JpaRepository<Model, Integer>{

    List<Model> findModelsByStartUrlAndCurrentLevelOrderByCurrentLevel(String startUrl, int currentLevel);

    List<Model> findModelsByStartUrlOrderByCurrentLevel(String startUrl);

}
