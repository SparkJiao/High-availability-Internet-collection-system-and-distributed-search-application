package com.sdu.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kkkkkk on 2018/7/25.
 */
public class CookieUtils {

    public static void setCookie(HttpServletResponse response, String name, String value, int maxAge){
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static String getCookie(Cookie cookies[], String name){
        if(cookies!=null){
            for(int i=0;i<cookies.length;i++){
                if(cookies[i].getName().equals(name)){
                    return cookies[i].getValue();
                }
            }
        }
        return null;
    }
}
