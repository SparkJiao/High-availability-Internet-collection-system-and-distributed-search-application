package com.sdu.controller;

import com.sdu.entity.Administrator;
import com.sdu.entity.User;
import com.sdu.repository.AdministratorRepository;
import com.sdu.utils.CookieUtils;
import com.sdu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kkkkkk on 2018/7/6.
 */
@RestController
public class AdministratorController {

    @Autowired
    AdministratorRepository administratorRepository;

    @RequestMapping("/adminLogin")
    public Message login(HttpServletResponse response, String username, String password) {
        Administrator administrator = administratorRepository.findAdministratorByUsername(username);
        if (administrator == null) {
            return new Message(false, "no such administrator");
        } else {
            if (administrator.getPassword().equals(password)) {
                CookieUtils.setCookie(response, "username", username, 7200);
                CookieUtils.setCookie(response, "password", password, 7200);
                return new Message(true);
            } else {
                return new Message(false, "wrong password");
            }
        }
    }

    @RequestMapping("/adminRegister")
    public Message register(String username, String password) {
        Administrator administrator = administratorRepository.findAdministratorByUsername(username);
        if (administrator == null) {
            administratorRepository.save(new Administrator(username, password));
            return new Message(true);
        } else {
            return new Message(false, "no such administrator");
        }
    }

    @RequestMapping("/adminAttempt")
    public Message adminAttempt(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String username = CookieUtils.getCookie(cookies, "username");
        String password = CookieUtils.getCookie(cookies, "password");
        if (username != null && password != null) {
            Administrator administrator = administratorRepository.findAdministratorByUsername(username);
            if (administrator != null && administrator.getPassword().equals(password)) {
                return new Message(true, username);
            }
        }
        return new Message(false);
    }
}
