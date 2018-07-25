package com.sdu.controller;

import com.sdu.entity.Model;
import com.sdu.entity.Template;
import com.sdu.repository.ModelRepository;
import com.sdu.repository.TemplateRepository;
import com.sdu.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkkkkk on 2018/7/16.
 */

@RestController
public class ManageController {

    @Autowired
    private TemplateRepository templateRepository;
    @Autowired
    private ModelRepository modelRepository;

    @RequestMapping("/addTemplate")
    public Message addTemplate(@RequestBody TemplateView templateView){
        //Template template = new Template(startUrl,isDynamic,level, headers);
        //System.out.println(startUrl);
        //System.out.println(level);
        //System.out.println(headers);
        //System.out.println(isDynamic);
        //templateRepository.save(template);

        templateRepository.save(new Template(templateView));
        List<MatchModel> matchModelList= templateView.getMatchModelList();
        //System.out.println(MatchModelList == null);
        for(int i=0;i<matchModelList.size();i++){
            Model model = new Model(templateView.getStartUrl(),matchModelList.get(i));
            modelRepository.save(model);
            System.out.println(model);
        }
        return new Message(true, "success", templateView);
    }

    @RequestMapping("/getAllTemplates")
    public List<TemplateView> getAllTemplates(){
        List<Template> templateModels = templateRepository.findAllByOrderByStartTime();
        List<TemplateView> templateViews = new ArrayList<>();
        for(int i=0;i<templateModels.size();i++){
            System.out.println(templateModels.get(i));
            Template templateModel = templateModels.get(i);
            List<Model> models = modelRepository.findModelsByStartUrlOrderByCurrentLevel(templateModel.getStartUrl());
            List<MatchModel> matchModels = new ArrayList<>();
            for(int j=0;j<models.size();j++){
                Model model = models.get(j);
                matchModels.add(new MatchModel(model.getCurrentLevel(),model.getToken(), model.getPattern(), model.getWherePagenumber(), model.getWhereSize(), model.getTotal()));
            }
            //List<MatchModel> matchModelList = matchRepository.findMatchModel(templateModel.getStartUrl());
            TemplateView templateView = new TemplateView(templateModel, matchModels);
            templateViews.add(templateView);
        }
        return templateViews;
    }

    @RequestMapping("/deleteTemplate")
    public Message deleteTemplate(String startUrl){
        modelRepository.deleteModelsByStartUrl(startUrl);
        templateRepository.deleteTemplatesByStartUrl(startUrl);
        return new Message(true);
    }
}
