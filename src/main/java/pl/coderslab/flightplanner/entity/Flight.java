package pl.coderslab.flightplanner.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.minidev.json.JSONObject;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    private String id;
    private String departureCity;
    private String departureDate;
    private String departureTime;
    private String arrivalCity;
    @OneToMany(mappedBy = "flight")
    private List<TravelPlan> travelPlans = new ArrayList<>();

    public Flight() {

    }


    public Flight(String departureCity, String departureDate, String departureTime, String arrivalCity) {
        this.departureCity = departureCity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalCity = arrivalCity;
    }
}
