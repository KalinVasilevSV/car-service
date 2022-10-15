package org.webserve.carservice.car.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webserve.carservice.car.data.Car;
import org.webserve.carservice.car.repository.CarDataRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarDataService {

    private final CarDataRepository carDataRepository;
    private final ModelMapper modelMapper;

    // Yeah, I know. I shouldn't have such a method but there will never be too much data in this app :P
    public List<Car> getAllCars(){
        return carDataRepository.findAll();
    }

    public List<Car> getByCurrentOwner(String currentOwner){
        return carDataRepository.findByCurrentOwner(currentOwner);
    }

    public Optional<Car> getByRegistration(String registration){
        return carDataRepository.findByRegistration(registration).map(Car -> modelMapper.map(Car,Car.class));
    }
}