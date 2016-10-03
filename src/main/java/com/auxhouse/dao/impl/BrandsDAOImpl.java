package com.auxhouse.dao.impl;

import com.auxhouse.dao.BrandsDAO;
import com.auxhouse.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by harikrishnan on 10/1/16.
 */

@Repository
public class BrandsDAOImpl implements BrandsDAO {


    private NamedParameterJdbcTemplate template;

    @Autowired
    public BrandsDAOImpl(DataSource ds) {
        template = new NamedParameterJdbcTemplate(ds);
    }

    @Override
    public List<Brand> GetAllBrands(){
        Map<String, Object> params = new HashMap<String, Object>();

        String sql = "SELECT `t_brands`.`id`," +
                "    `t_brands`.`brand_name`," +
                "    `t_brands`.`brand_image_url`," +
                "    `t_brands`.`is_archive`, " +
                "    `t_brands`.`query_id`" +
                "FROM `aux_house_prod_v2`.`t_brands`;";
        List <Brand> results = template.query(sql, params, brandsMapper);

        return results;
    }

    @Override
    public int DeleteBrand(List<Brand> brands){
        Map<String, Object> params = new HashMap<String, Object>();

        String sql = "DELETE FROM 't_brands' WHERE id =:brand_id";

        int rows = template.update(sql, params);

        return rows;
    }


    //Housekeeping functions
    private RowMapper<Brand> brandsMapper = (rs, rowNum) ->{
        Brand b = new Brand();

        b.setBrand_id(rs.getInt("id"));
        b.setBrand_name(rs.getString("brand_name"));
        b.setBrand_image_url(rs.getString("brand_image_url"));

        return b;
    };
}