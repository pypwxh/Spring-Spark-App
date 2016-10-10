package com.codeoccult.syncapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by harikrishnan on 10/9/16.
 */

@RestController
public class RoutesConfig {
    @RequestMapping("/greeting")
    public String helloworld(){
        return "Hello World";
    }
}
