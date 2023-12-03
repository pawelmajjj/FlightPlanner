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

    private String destinationCity;

    private String travelDate;
    private String travelTime;

    @OneToMany(mappedBy = "flight")
    private List<TravelPlan> travelPlans = new ArrayList<>();

    public Flight() {

    }

    public Flight(String departureCity, String destinationCity, String travelDate, String travelTime, List<TravelPlan> travelPlans) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.travelDate = travelDate;
        this.travelTime = travelTime;
        this.travelPlans = travelPlans;
    }
}
