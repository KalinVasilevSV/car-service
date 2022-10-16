package org.webserve.carservice.car.data;

import lombok.Data;
import org.webserve.carservice.carservice.data.CarService;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;

import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.EAGER;

@Entity
@Data
public class Car {
    @Id
    private Long id;
    @NotBlank
    private String currentOwner;
    @NotBlank
    private String make;
    @NotBlank
    private String model;
    @NotNull
    private Date productionYear;
    @NotBlank
    private String registration;
    @OneToMany(mappedBy = "car", fetch = EAGER, cascade = REMOVE)
    private Set<CarService> carService;
}
