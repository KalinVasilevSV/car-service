package org.webserve.carservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class CarServiceApp {
    public static void main(String[] args){
        SpringApplication.run(CarServiceApp.class);
    }
}
