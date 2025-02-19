package com.example.wooamo_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@PropertySource("classpath:.env")
public class WooamoTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WooamoTestApplication.class, args);
    }

}
