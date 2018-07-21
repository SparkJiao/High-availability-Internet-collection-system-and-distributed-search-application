package com.sdu.controller;

import com.sdu.entity.UrlInfo;
import com.sdu.repository.UrlInfoRepository;
import com.sdu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by kkkkkk on 2018/7/16.
 */

@RestController
public class UrlInfoController {

    @Autowired
    private UrlInfoRepository urlInfoRepository;

    @RequestMapping("/addUrlInfo")
    public Message addUrlInfo(@RequestBody Map<String, String> require) {
        String url = require.get("url");
        String startUrl = require.get("startUrl");
        Integer currentLevel = new Integer(require.get("currentLevel"));
        //Integer currentlevel = new Integer(currentLevel);
        System.out.println(url + " " + startUrl + " " + currentLevel);
        UrlInfo urlInfo = new UrlInfo(url, startUrl, currentLevel);
        urlInfoRepository.save(urlInfo);
        return new Message(true);
    }

    @RequestMapping("/findNextUrl")
    public List<String> findNextUrl(@RequestBody Map<String, String> body) {
        String startUrl = body.get("startUrl");
        Integer currentLevel = new Integer(body.get("currentLevel"));
        return urlInfoRepository.findUrlsByStartUrlAndCurrentLevel(startUrl, currentLevel);
    }
}
