package com.sdu.controller;

import com.sdu.entity.Parameter;
import com.sdu.repository.ParameterRepository;
import com.sdu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NamedStoredProcedureQueries;
import java.util.List;
import java.util.Map;

/**
 * Created by kkkkkk on 2018/7/16.
 */

@RestController
public class ParameterController {

    @Autowired
    private ParameterRepository parameterRepository;

    @RequestMapping("/addParameters")
    public Message addParameters(@RequestBody Map<String, String> body){
        String url = body.get("url");
        Integer rank = new Integer(body.get("rank"));
        String name = body.get("name");
        String value = body.get("value");
        Parameter parameter = new Parameter(url, rank, name, value);
        parameterRepository.save(parameter);
        System.out.println(url + " " + rank + " " + name + " " + value);
        return new Message(true);
    }

    @RequestMapping("/findParameters")
    public List<Parameter> findParameters(@RequestBody Map<String, String> body){
        String url = body.get("url");
        System.out.println(url);
        return parameterRepository.findParametersByUrlOrderByRank(url);
    }
}
