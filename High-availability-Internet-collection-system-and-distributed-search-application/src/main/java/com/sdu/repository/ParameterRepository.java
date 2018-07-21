package com.sdu.repository;

import com.sdu.entity.Parameter;
import com.sdu.entity.ParameterKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/16.
 */
public interface ParameterRepository extends JpaRepository<Parameter, ParameterKey>{

    List<Parameter> findParametersByUrlOrderByRank(String url);
}
