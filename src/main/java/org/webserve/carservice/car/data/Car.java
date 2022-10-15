package org.webserve.carservice.car.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class Car {
    @Id
    private Long id;
    private String currentOwner;
    private String make;
    private String model;
    private Date productionYear;
    private String registration;
}
