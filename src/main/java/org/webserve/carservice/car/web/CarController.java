package org.webserve.carservice.car.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public String addCar(@ModelAttribute Car car, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "/car/addCar";
        }

        Long savedCarId = carDataService.saveCar(car).getId();
        redirectAttributes.addAttribute("savedCarId",savedCarId);
        return "redirect:/cars/{savedCarId}";
    }

    @GetMapping("/editCar")
    public String editCar(@RequestParam Long id, Model model){
        Car car = carDataService.getById(id).orElseThrow();
        model.addAttribute("car",car);
        return "/car/editCar";
    }

    @PostMapping("/editCar")
    public String editCar(@ModelAttribute Car car, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors())
            return "/car/editCar";

        Long editedCarId = car.getId();
        redirectAttributes.addAttribute("editedCarId",editedCarId);
        carDataService.saveCar(car);
        return "redirect:/cars/{editedCarId}";
    }

    @PostMapping("/deleteCar")
    public String deleteCar(@RequestParam Long id){
        carDataService.deleteCarById(id);
        return "/car/viewAllCars";
    }
}
