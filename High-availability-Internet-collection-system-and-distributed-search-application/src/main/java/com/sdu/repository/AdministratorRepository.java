package com.sdu.repository;

import com.sdu.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kkkkkk on 2018/7/6.
 */
public interface AdministratorRepository extends JpaRepository<Administrator, String>{

    Administrator findAdministratorByUsername(String username);
}
