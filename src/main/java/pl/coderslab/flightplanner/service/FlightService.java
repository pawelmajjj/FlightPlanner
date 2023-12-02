package pl.coderslab.flightplanner.service;

import pl.coderslab.flightplanner.entity.Flight;

import java.util.List;

public interface FlightService {
    public List<Flight> getFlights();
    public void save(Flight flight);
    public Flight findById(Integer id);
    public void delete(Flight flight);
}
