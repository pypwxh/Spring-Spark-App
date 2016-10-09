package com.auxhouse;

/**
 * Created by harikrishnan on 9/30/16.
 */

import com.auxhouse.config.RouteConfig;
import com.auxhouse.config.DBConfig;
import com.auxhouse.service.ServiceManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan({ "com.*" })

public class StartingPoint {
    public static void main(String[] args) {
        System.out.println("====== Application started ======");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(StartingPoint.class);
        new RouteConfig(ctx.getBean(ServiceManager.class));
        new DBConfig();
        ctx.registerShutdownHook();
    }
}
