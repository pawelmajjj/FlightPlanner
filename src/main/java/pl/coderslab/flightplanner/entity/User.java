package pl.coderslab.flightplanner.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User {

    @Id
    private String email;

    private String firstName;

    private String lastName;

    private String birthDate;

    private String password;

    @OneToMany(mappedBy="owner")
    private List<TravelPlan> travelPlans = new ArrayList<>();


    public User(String firstName, String lastName, String birthDate, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

}
