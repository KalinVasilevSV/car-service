package org.webserve.carservice.carservice.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Data
public class CarService {
    @Id
    private Long id;
    @NotNull
    private Date date;
    @NotNull
    private Long odometerReading;
    @NotBlank
    private String description;
    private boolean scheduled;
    @NotNull
    private Date nextDate;
    @NotNull
    private Long nextChangeIn;
}
