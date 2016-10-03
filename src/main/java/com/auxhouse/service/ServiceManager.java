package com.auxhouse.service;

import com.auxhouse.dao.BrandsDAO;
import com.auxhouse.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by harikrishnan on 9/30/16.
 */

@Service
public class ServiceManager {

    @Autowired
    BrandsDAO brandsdao;

    @Bean
    public List<Brand> getBrands(){
        return brandsdao.GetAllBrands();
    }

    @Bean
    public int deleteBrands(List<Brand> brandsList) { return brandsdao.DeleteBrand(brandsList); }
}
