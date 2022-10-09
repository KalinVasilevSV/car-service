package org.webserve.carservice.car.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    @GetMapping("/")
    public String home(){
        return "/home";
    }
}
