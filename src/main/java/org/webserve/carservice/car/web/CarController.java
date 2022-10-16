package org.webserve.carservice.car.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarController {

    @GetMapping
    public String cars() {
        return "redirect:/cars/viewAllCars";
    }

    @RequestMapping("/viewAllCars")
    public String viewAllCars() {
        return "/car/viewAllCars";
    }

}
