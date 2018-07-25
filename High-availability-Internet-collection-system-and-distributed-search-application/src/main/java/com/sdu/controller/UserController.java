package com.sdu.controller;

import com.sdu.entity.Cutoff;
import com.sdu.entity.ExpectMajor;
import com.sdu.entity.User;
import com.sdu.repository.CollectionRepository;
import com.sdu.repository.CutoffRepository;
import com.sdu.repository.ExpectMajorRepository;
import com.sdu.repository.UserRepository;
import com.sdu.utils.CookieUtils;
import com.sdu.utils.CutoffView;
import com.sdu.utils.MD5;
import com.sdu.utils.Message;
import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kkkkkk on 2018/7/3.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CutoffRepository cutoffRepository;

    @Autowired
    private ExpectMajorRepository expectMajorRepository;

    @RequestMapping("/login")
    public Message login(HttpServletResponse response, String username, String password) {
        String md_password = MD5.md5(password);
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            return new Message(false, "can'f find such user!");
        } else {
            if (!user.getPassword().equals(md_password)) {
                return new Message(false, "incorrect password!");
            } else {
                CookieUtils.setCookie(response, "username", username, 7200);
                CookieUtils.setCookie(response, "password", md_password, 7200);
                return new Message(true, "success");
            }
        }
    }

    @RequestMapping("/usernameExist")
    public Message ifUsernameExist(String username) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            return new Message(true, "success");
        } else {
            return new Message(false, "the username has been registered !");
        }
    }

    @RequestMapping("/register")
    public Message register(HttpServletResponse response, String username, String password) {
        Message msg = ifUsernameExist(username);
        if (!msg.isFlag()) return msg;
        String md_password = MD5.md5(password);
        userRepository.save(new User(username, md_password));
        CookieUtils.setCookie(response, "username", username, 7200);
        CookieUtils.setCookie(response, "password", md_password, 7200);
        return new Message(true, "success");
    }

    @RequestMapping("/setUserInfo")
    public Message setUserInfo(String username, String category, String province, String grade) {
        Message msg = ifUsernameExist(username);
        if (msg.isFlag()) {
            msg.setFlag(false);
            msg.setMsg("no such user");
            return msg;
        }
        userRepository.setUserInfo(username, category, province, grade);
        return new Message(true);
    }

    @RequestMapping("/changePassword")
    public Message changePassword(String username, String password) {
        Message msg = ifUsernameExist(username);
        if (msg.isFlag()) {
            msg.setFlag(false);
            msg.setMsg("no such user");
            return msg;
        }
        userRepository.changePassword(username, password);
        return new Message(true);
    }


    @RequestMapping("/getSchoolExpectMajors")
    public Message findSchoolExpectMajors(String username, String school) {
        User user = userRepository.findUserByUsername(username);
        String province = user.getProvince();
        if (province == null || province.equals("")) {
            return new Message(false, "please complete your personal information first!");
        }
        List<String> expectMajors = expectMajorRepository.findUsersMajor(username);
        List<Cutoff> cutoffs = new ArrayList<>();
        Iterator<String> iterator = expectMajors.iterator();
        while (iterator.hasNext()) {
            String major = iterator.next();
            System.out.println(major.length());
            System.out.println(school + " " + province + " " + major);
            List<Cutoff> tmp = cutoffRepository.findCutoffsBySchoolNameAndProvinceAndMajorContains(school, province, major);
            System.out.println("size = " + cutoffs.size());
            cutoffs.addAll(tmp);
        }
        return new Message<List>(true, "", cutoffs);
    }

    @RequestMapping("/attempt")
    public Message attempt(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String username = CookieUtils.getCookie(cookies, "username");
        String password = CookieUtils.getCookie(cookies, "password");
        if (username != null && password != null) {
            User user = userRepository.findUserByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                return new Message(true, username);
            }
        }
        return new Message(false);
    }
}
