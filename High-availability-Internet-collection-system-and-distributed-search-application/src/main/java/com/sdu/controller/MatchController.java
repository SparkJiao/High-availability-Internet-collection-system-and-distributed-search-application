package com.sdu.controller;

import com.sdu.entity.Model;
import com.sdu.repository.ModelRepository;
import com.sdu.utils.MatchView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kkkkkk on 2018/7/16.
 */

@RestController
public class MatchController {

    @Autowired
    private ModelRepository modelRepository;

    @RequestMapping("/findMatchInfo")
    public List<MatchView> findMatchInfo(@RequestBody Map<String, String> body) {
        String startUrl = body.get("startUrl");
        Integer currentLevel = new Integer(body.get("currentLevel"));
        List<Model> models = modelRepository.findModelsByStartUrlAndCurrentLevelOrderByCurrentLevel(startUrl, currentLevel);
        List<MatchView> matchViews = new ArrayList<>();
        for (int i = 0; i < models.size(); i++) {
            Model model = models.get(i);
            MatchView matchView = new MatchView(model.getToken(), model.getPattern(), model.getWherePagenumber(), model.getWhereSize(), model.getTotal());
            matchViews.add(matchView);
        }
        return matchViews;
    }
}
