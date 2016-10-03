package com.auxhouse.config;

import com.auxhouse.pojo.Brand;
import com.auxhouse.service.ServiceManager;
import com.auxhouse.utils.JsonTransformer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static spark.Spark.*;
import static spark.SparkBase.staticFileLocation;

/**
 * Created by harikrishnan on 9/30/16.
 */
public class RouteConfig {

    private ServiceManager service;

    public RouteConfig(ServiceManager service) {
        this.service = service;
        staticFileLocation("/public");
        setupRoutes();
    }

    public void setupRoutes(){

        //Common methods

        before((req, res) -> {

            res.type("application/json");

            boolean authenticated = true;

            if (!authenticated) {
                halt(401, "You are not welcome here");
            }
        });


        //Individual routes

        //Hello World
        get("/", (req, res) -> "Hello World");


        //Get all the brands
        get("/getbrands", (req, res) -> {
            return service.getBrands();
        }, new JsonTransformer());


        //Delete brands
        post("/deletebrands", (req, res) -> {
            List<Brand> brands;

            return service.deleteBrands(brands);
        }, new JsonTransformer());

    }

}
