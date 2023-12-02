package pl.coderslab.flightplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.flightplanner.entity.Flight;

//JpaRepository interface has some basic CRUD methods
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
/*
    Optional<User> findUserByEmail(String email);

 */
}
