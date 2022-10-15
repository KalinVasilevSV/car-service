package org.webserve.carservice.carservice.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class CarService {
    @Id
    private Long id;
    private Date date;
    private Long odometerReading;
    private String description;
    private boolean scheduled;
    private Date nextDate;
    private Long nextChangeIn;
}
