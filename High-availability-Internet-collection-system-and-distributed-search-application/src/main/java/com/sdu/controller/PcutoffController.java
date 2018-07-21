package com.sdu.controller;

import com.sdu.entity.Pcutoff;
import com.sdu.entity.PcutoffKey;
import com.sdu.repository.PcutoffRepository;
import com.sdu.utils.Message;
import com.sdu.utils.PcutoffList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Created by kkkkkk on 2018/7/3.
 */

@RestController
public class PcutoffController {

    @Autowired
    private PcutoffRepository pcutoffRepository;


    @RequestMapping("/findPcutoffByProvince")
    public Message<Pcutoff> findPcutoffByProvince(String province){
        /*Pcutoff pcutoff = pcutoffRepository.findPcutoffByProvince(province);
        if(pcutoff == null)
            return new Message<>(false,"no information of the province");
        else
            return new Message<>(true,"success",pcutoff);*/
        return new Message<>(true);
    }

    @RequestMapping("/searchPcutoff")
    public List<Pcutoff> searchPcutoff(String province){
        System.out.println(province);
        return pcutoffRepository.findPcutoffsByProvince(province);
    }

    @RequestMapping("/addPcutoff")
    public Message addPcutoff(@RequestBody PcutoffList pcutoffList){
        List<Pcutoff> pcutoffs = pcutoffList.getPcutoffs();
        System.out.println("pcutoffs here:" + pcutoffs.size());
        for(int i=0;i<pcutoffs.size();i++){
            Pcutoff pcutoff = pcutoffs.get(i);
            System.out.println(pcutoff);
            pcutoffRepository.save(pcutoff);
        }
        return new Message<>(true);
    }
}
