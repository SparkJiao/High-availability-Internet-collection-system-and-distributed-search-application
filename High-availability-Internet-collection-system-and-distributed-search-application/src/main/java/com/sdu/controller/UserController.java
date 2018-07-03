package com.sdu.controller;

import com.sdu.entity.User;
import com.sdu.repository.UserRepository;
import com.sdu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kkkkkk on 2018/7/3.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/login")
    public Message login(String username, String password){
        User user = userRepository.findUserByUsername(username);
        if(user==null){
            return new Message(false,"can'f find such user!");
        }else{
            if(!user.getPassword().equals(password)){
                return new Message(false,"incorrect password!");
            }else{
                return new Message(true,"success");
            }
        }
    }

    @RequestMapping("/usernameExist")
    public Message ifUsernameExist(String username){
        User user = userRepository.findUserByUsername(username);
        if(user==null){
            return new Message(true,"success");
        }else{
            return new Message(false,"the username has been registered !");
        }
    }

    @RequestMapping("/register")
    public Message register(String username, String password){
        Message msg = ifUsernameExist(username);
        if(!msg.isFlag()) return msg;
        userRepository.save(new User(username, password));
        return new Message(true, "success");
    }

    @RequestMapping("/setUserInfo")
    public Message setUserInfo(String username, String category, String province, String grade){
        Message msg = ifUsernameExist(username);
        if(!msg.isFlag())
            return msg;
        userRepository.setUserInfo(username, category, province, grade);
        return new Message(true);
    }

    @RequestMapping("/changePassword")
    public Message changePassword(String username, String password){
        Message msg = ifUsernameExist(username);
        if(!msg.isFlag())
            return msg;
        userRepository.changePassword(username, password);
        return new Message(true);
    }
}
