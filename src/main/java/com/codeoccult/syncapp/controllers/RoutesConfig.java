package com.codeoccult.syncapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by harikrishnan on 10/9/16.
 */

@RestController
public class RoutesConfig {
    @Autowired
    private ApplicationContext ctx;

    @RequestMapping("/greeting")
    public String helloworld(){
        return "Hello World";
    }

   /* @RequestMapping("/shutdown")
    public void shutdown(){
        ((ConfigurableApplicationContext) ctx).close();
    }
    */
}
