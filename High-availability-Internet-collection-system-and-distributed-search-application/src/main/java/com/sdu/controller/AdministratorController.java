package com.sdu.controller;

import com.sdu.entity.Administrator;
import com.sdu.repository.AdministratorRepository;
import com.sdu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kkkkkk on 2018/7/6.
 */
@RestController
public class AdministratorController {

    @Autowired
    AdministratorRepository administratorRepository;

    @RequestMapping("/adminLogin")
    public Message login(String username, String password){
        Administrator administrator = administratorRepository.findAdministratorByUsername(username);
        if(administrator==null){
            return new Message(false,"no such administrator");
        }else{
            if(administrator.getPassword().equals(password)){
                return new Message(true);
            }else{
                return new Message(false,"wrong password");
            }
        }
    }

    @RequestMapping("/adminRegister")
    public Message register(String username, String password){
        Administrator administrator = administratorRepository.findAdministratorByUsername(username);
        if(administrator==null){
            administratorRepository.save(new Administrator(username, password));
            return new Message(true);
        }else{
            return new Message(false,"no such administrator");
        }
    }
}
