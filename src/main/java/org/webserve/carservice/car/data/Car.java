package org.webserve.carservice.car.data;

import lombok.Data;
import org.webserve.carservice.carservice.data.CarService;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;

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
    //TODO
    // solve table reference
//    @OneToMany(targetEntity = CarService.class)
//    private Set<CarService> serviceHistory;
}
