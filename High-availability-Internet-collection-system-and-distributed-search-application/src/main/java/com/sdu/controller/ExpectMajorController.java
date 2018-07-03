package com.sdu.controller;

import com.sdu.entity.ExpectMajor;
import com.sdu.repository.ExpectMajorRepository;
import com.sdu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/3.
 */

@RestController
public class ExpectMajorController  {

    @Autowired
    private ExpectMajorRepository expectMajorRepository;

    @RequestMapping("/addExpectMajor")
    public Message addExpectMajor(String username, String major){
        expectMajorRepository.save(new ExpectMajor(username, major));
        return new Message(true);
    }

    @RequestMapping("/findUsersExpectMajor")
    public List<String> findUsersExpectMajor(String username){
        return expectMajorRepository.findUsersMajor(username);
    }
}
