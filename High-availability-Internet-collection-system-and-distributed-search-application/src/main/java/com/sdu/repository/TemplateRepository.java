package com.sdu.repository;

import com.sdu.entity.Template;
import com.sdu.utils.TemplateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/16.
 */
public interface TemplateRepository extends JpaRepository<Template, String>{

    @Transactional
    @Modifying
    @Query("update Template as t set t.status = ?2 where t.startUrl = ?1")
    void setStatus(String startUrl, String status);

    List<Template> findAllByOrderByStartTime();
}
