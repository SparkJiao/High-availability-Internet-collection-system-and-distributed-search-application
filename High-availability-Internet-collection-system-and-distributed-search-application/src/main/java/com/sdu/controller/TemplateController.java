package com.sdu.controller;

import com.sdu.entity.Template;
import com.sdu.repository.TemplateRepository;
import com.sdu.utils.Message;
import com.sdu.utils.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkkkkk on 2018/7/16.
 */

@RestController
public class TemplateController {

    @Autowired
    private TemplateRepository templateRepository;

    @RequestMapping("/setStatus")
    public Message setStatus(String startUrl, String status){
        templateRepository.setStatus(startUrl, status);
        return new Message(true);
    }

    @RequestMapping("/findAll")
    public List<TemplateModel> findAll(){
        List<Template> templates = templateRepository.findAllByOrderByStartTime();
        List<TemplateModel> templateModels = new ArrayList<>();
        for(int i=0;i<templates.size();i++){
            Template template = templates.get(i);
            TemplateModel templateModel = new TemplateModel(template.getStartUrl(), template.isDynamic(),template.getLevel(), template.getTarget(),template.getHeaders());
            templateModels.add(templateModel);
        }
        return templateModels;
    }
}
