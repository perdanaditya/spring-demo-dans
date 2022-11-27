package com.spring.demo.dans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 * @author Rizky Perdana
 */
@ComponentScan(
    basePackages = {
        "com.spring.demo.dans.dao",
        "com.spring.demo.dans.service",
        "com.spring.demo.dans.libraries",
        "com.spring.demo.dans.rest.web"
    })
//@EnableR2dbcRepositories(basePackages = {
//    "com.spring.demo.dans.dao",
//    "com.spring.demo.dans.entity"
//})
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
