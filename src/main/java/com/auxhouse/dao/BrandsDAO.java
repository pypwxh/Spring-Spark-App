package com.auxhouse.dao;

import com.auxhouse.pojo.Brand;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by harikrishnan on 10/1/16.
 */
@Component
public interface BrandsDAO {

    //Get all brands
    List<Brand> GetAllBrands();

    //Delete a brand
    int DeleteBrand(List<Brand> brands);

}
