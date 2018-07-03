package com.sdu.controller;

import com.sdu.entity.Pcutoff;
import com.sdu.repository.PcutoffRepository;
import com.sdu.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/3.
 */

@RestController
public class PcutoffController {

    @Autowired
    private PcutoffRepository pcutoffRepository;


    @RequestMapping("/findPcutoffByProvince")
    public Message<Pcutoff> findPcutoffByProvince(String province){
        Pcutoff pcutoff = pcutoffRepository.findPcutoffByProvince(province);
        if(pcutoff == null)
            return new Message<>(false,"no information of the province");
        else
            return new Message<>(true,"success",pcutoff);
    }

}
