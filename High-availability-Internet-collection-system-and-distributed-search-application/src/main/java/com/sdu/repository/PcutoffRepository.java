package com.sdu.repository;

import com.sdu.entity.Pcutoff;
import com.sdu.entity.PcutoffKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by kkkkkk on 2018/7/3.
 */
public interface PcutoffRepository extends JpaRepository<Pcutoff, PcutoffKey>{

    List<Pcutoff> findPcutoffsByProvince(String province);

}
