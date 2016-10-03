package com.auxhouse.pojo;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

/**
 * Created by harikrishnan on 10/1/16.
 */
@Repository
public class Brand {

    private int brand_id;

    private String brand_name;

    private String brand_image_url;

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public void setBrand_image_url(String brand_image_url) {
        this.brand_image_url = brand_image_url;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public String getBrand_image_url() {
        return brand_image_url;
    }

    public void setBrand_id(int id){
        this.brand_id = id;
    }

    public int getBrand_id(){
        return this.brand_id;
    }
}
