package com.sdu.repository;

import com.sdu.entity.Pcutoff;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kkkkkk on 2018/7/3.
 */
public interface PcutoffRepository extends JpaRepository<Pcutoff, String>{

    Pcutoff findPcutoffByProvince(String province);

}
