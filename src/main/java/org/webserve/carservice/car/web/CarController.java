package org.webserve.carservice.car.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.webserve.carservice.car.data.Car;
import org.webserve.carservice.car.service.CarDataService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarDataService carDataService;

    @GetMapping
    public String cars() {
        return "redirect:/cars/viewAllCars";
    }

    @RequestMapping("/viewAllCars")
    public String viewAllCars(Model model) {
        model.addAttribute("cars",carDataService.getAllCars());
        return "/car/viewAllCars";
    }

    @RequestMapping("/{carId}")
    public String viewCar(@PathVariable Long carId, Model model){
        model.addAttribute( "car",carDataService.getById(carId).orElseThrow());
        return "/car/viewCar";
    }

    // Adding, editing and deleting cars
    @GetMapping("/addCar")
    public String addCar(Model model){
        model.addAttribute("car",new Car());
        return "/car/addCar";
    }
    @PostMapping("/addCar")
    public String addCar(@ModelAttribute Car car, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/car/addCar";
        }

        carDataService.saveCar(car);
        return "/car/viewCar";
    }

    @PostMapping("/editCar")
    public String editCar(@ModelAttribute Car car, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/car/editCar";

        carDataService.saveCar(car);
        return "/car/viewCar";
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@ModelAttribute Car car,BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "/car/viewCar";
        //TODO
        // change view
        carDataService.deleteCar(car);
        return "/car/viewAllCars";
    }
}
