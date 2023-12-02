package pl.coderslab.flightplanner.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "travelplan")
public class TravelPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String startDate;
    @ManyToOne
    private User owner;
    @ManyToOne
    private Flight flight;

    public TravelPlan() {
    }

    public TravelPlan(String name, String startDate, User owner, Flight flight) {
        this.name = name;
        this.startDate = startDate;
        this.owner = owner;
        this.flight = flight;
    }
}
