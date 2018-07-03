package com.sdu.repository;


import com.sdu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kkkkkk on 2018/7/3.
 */
public interface UserRepository extends JpaRepository<User, String>{

    User findUserByUsername(String username);

    @Transactional
    @Modifying
    @Query("update User as u set u.category = ?2, u.province = ?3, u.grade = ?4 where u.username = ?1")
    void setUserInfo(String username, String category, String province, String grade);

    @Transactional
    @Modifying
    @Query("update User as u set u.password = ?2 where u.username = ?1")
    void changePassword(String usermname, String password);
}
