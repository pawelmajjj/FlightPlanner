package pl.coderslab.flightplanner.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.flightplanner.service.FlightServiceImpl;

@RestController
@RequiredArgsConstructor
public class FlightRestController {

    private final FlightServiceImpl flightService;

   // @GetMapping


/*
    @GetMapping("/getCities")
    public ResponseEntity<?> getCities() {
        return ResponseEntity.ok(flightService.getFlights());
    }

    @PostMapping("/getCities")
    public ResponseEntity<?> showCities(@Valid @RequestBody PokeResult pokeResult) {
       // PokeResult pokeResult = 1
        return ResponseEntity.ok(flightService.getFlights());
    }
/*
    @PostMapping("/getCities")
    @ResponseBody
    public String showCities() {
        return flightService.getRetrievedData().toString();
    }*/
}
