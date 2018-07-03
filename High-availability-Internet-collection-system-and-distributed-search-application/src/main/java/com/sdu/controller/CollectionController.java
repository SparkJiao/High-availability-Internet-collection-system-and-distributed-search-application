package com.sdu.controller;

import com.sdu.entity.Collection;
import com.sdu.repository.CollectionRepository;
import com.sdu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by kkkkkk on 2018/7/3.
 */

@RestController
public class CollectionController {

    @Autowired
    private CollectionRepository collectionRepository;

    @RequestMapping("/addSchool")
    public Message addSchool(String username, String school){
        collectionRepository.save(new Collection(username, school));
        return new Message(true);
    }

    @RequestMapping("/findUsersSchool")
    public List<String> findUsersSchool(String username){
        return collectionRepository.findUsersSchool(username);
    }
}
