package pl.coderslab.flightplanner.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.flightplanner.entity.Flight;
import pl.coderslab.flightplanner.entity.FlightDto;
import pl.coderslab.flightplanner.entity.TravelPlan;
import pl.coderslab.flightplanner.service.FlightServiceImpl;
import pl.coderslab.flightplanner.service.TravelPlanServiceImpl;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightServiceImpl flightService;

    @Autowired
    private final TravelPlanServiceImpl travelPlanService;

    private List<String> cityNames = Arrays.asList("Athens", "Dusseldorf", "Chicago", "Sao Paulo", "Helsinki", "Vienna",
            "Berlin", "Bogota", "London Luton", "New York", "Melbourne", "Cracow", "Paris", "Lisbon", "Seoul", "Gdansk", "Oslo",
            "Rome", "Toronto", "Madrid", "Tokio", "Singapore", "Warsaw", "Barcelona", "Stockholm", "Amsterdam", "Brussels",
            "Sydney", "Istanbul", "Porto", "Sevilla", "Marseille", "Milan", "Copenhagen", "Prague", "Mexico City", "Marrakesh").stream().sorted().toList();
    private List<String> cityCodes = Arrays.asList("ATH", "DUS", "CHI", "SAO", "HEL", "VIE",
            "BER", "BOG", "LTN", "JFK", "MEL", "KRK", "PAR", "LIS", "SEL", "GDN", "OSL",
            "ROM", "YTO", "MAD", "TYO", "SIN", "WAW", "BCN", "STO", "AMS", "BRU", "SYD", "IST", "OPO", "SVQ", "MRS",
            "MIL", "CPH", "PRG", "MEX", "MAR").stream().sorted().toList();

    private final Map<String, String> cities = IntStream.range(0, cityNames.size()).boxed().collect(Collectors.toMap(i -> cityNames.stream().sorted().toList().get(i), i -> cityCodes.stream().sorted().toList().get(i)));

    public FlightController(FlightServiceImpl flightService, TravelPlanServiceImpl travelPlanService) {
        this.flightService = flightService;
        this.travelPlanService = travelPlanService;
    }

    /*
        @GetMapping("/flight/list")
        public String showFlights(Model model, HttpSession session) {
            return "flightSummary";
        }
    */
    @GetMapping("/search/{planId}")
    public String findANewFlight(Model model, @PathVariable("planId") Integer planId, HttpSession session) {
        session.setAttribute("cityNames", cityNames);
        FlightDto flightDto = new FlightDto();
        flightDto.setTravelDate(travelPlanService.findById(planId).getStartDate());
        model.addAttribute("searchFlight", flightDto);
        return "flightSearch";
    }

    @PostMapping("/search/{planId}")
    public String findANewFlight(Model model, @PathVariable("planId") Integer planId, @Valid @ModelAttribute("searchFlight") FlightDto flightDto, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            result.getFieldErrors();
            return "redirect:/flight/search/".concat(planId.toString());
        }
        System.out.println(flightDto.getTravelDate() + " " + flightDto.getDestinationCity());

        List<Flight> foundFlights = flightService.test(flightDto.getDepartureCity(), flightDto.getDestinationCity(), flightDto.getTravelDate());
        model.addAttribute("foundFlights", foundFlights);
        model.addAttribute("currentPlan", planId);
        return "flightFound";
    //    return "/search/flightsFound/".concat(planId.toString());
//        System.out.println(newFlight.getArrivalCity() + " " + newFlight.getDepartureDate());
    //    TravelPlan tp = travelPlanService.findById(planId);
     //   tp.setFlight(newFlight);
   //     travelPlanService.update(tp);
       // return "/plan/details/".concat(planId.toString());
    }

    @PostMapping("/found/{travelPlanId}/{flightId}")
    public String addFlight(Model model, @PathVariable("travelPlanId") Integer travelPlanId, @PathVariable("flightId") String flightId) {
        TravelPlan travelPlan = travelPlanService.findById(travelPlanId);
        Flight flight = flightService.findFlight(flightId);
        travelPlan.setFlight(flight);
        travelPlanService.update(travelPlan);
        return "redirect:/plan/details/".concat(travelPlanId.toString());
    }



/*
    @GetMapping("/resetForm/{planId}")
    public String resetAddingForm(HttpSession session, @PathVariable("planId") Integer planId) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        session.removeAttribute("departureCity");
        session.removeAttribute("arrivalCity");
        session.setAttribute("loggedUser", loggedUser);
        return "redirect:/plan/details/".concat(planId.toString());
    }
*/
}
