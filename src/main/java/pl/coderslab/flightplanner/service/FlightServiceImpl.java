package pl.coderslab.flightplanner.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.coderslab.flightplanner.entity.Flight;
import pl.coderslab.flightplanner.repository.FlightRepository;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private static final String url = "https://pokeapi.co/api/v2/pokemon/";
    //   private List<PokeResult> data = new ArrayList<>();

    @Autowired
    private FlightRepository flightRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    @Override
    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public Flight findById(Integer id) {
        return flightRepository.findById(id).get();
    }

    public Flight findByData(String departureCity, String arrivalCity, String departureDate) {
        Query query = entityManager
                .createQuery("SELECT f FROM Flight f WHERE f.departureCity = :departureCity AND f.arrivalCity = :arrivalCity AND f.departureDate = :departureDate");
        query.setParameter("departureCity", departureCity);
        query.setParameter("arrivalCity", arrivalCity);
        query.setParameter("departureDate", departureDate);
        return (Flight) query.getResultList();
    }

    @Override
    public void delete(Flight flight) {
        flightRepository.delete(flight);
    }

    @Autowired
    private RestTemplate restTemplate;

/*
    public List<PokeResult> getdata() {
        String e_url = "https://pokeapi.co/api/v2/pokemon/"; //external API with above JSON data
        RestTemplate restTemplate = new RestTemplate();
        PokeResult[] pokemon = restTemplate.getForObject(e_url, PokeResult[].class);
        data = Arrays.asList(pokemon);
        return data;
    }

    public List<PokeResult> getRetrievedData() {
        return data;
    }
}
    /*
    public Object getAllFlightData() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Host", "pokeapi.co");
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);
            System.out.println(response.getBody());
            return response.getBody();

            List response = restTemplate.getForObject(url, List.class);
            return response;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception while catching endpoint of FlightApi");

        }*/
}

