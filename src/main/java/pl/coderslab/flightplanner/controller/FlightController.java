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
import pl.coderslab.flightplanner.entity.FlightList;
import pl.coderslab.flightplanner.entity.User;
import pl.coderslab.flightplanner.service.FlightService;
import pl.coderslab.flightplanner.service.FlightServiceImpl;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightServiceImpl flightService;
    private List<String> cityNames = Arrays.asList("Athens", "Dusseldorf", "Chicago", "Sao Paulo", "Helsinki", "Vienna",
            "Berlin", "Bogota", "London Luton", "New York", "Melbourne", "Cracow", "Paris", "Lisbon", "Seoul", "Gdansk", "Oslo",
            "Rome", "Toronto", "Madrid", "Tokio", "Singapore", "Warsaw", "Barcelona", "Stockholm", "Amsterdam", "Brussels",
            "Sydney", "Istanbul", "Porto", "Sevilla", "Marseille", "Milan", "Copenhagen", "Prague", "Mexico City", "Marrakesh").stream().sorted().toList();
    private List<String> cityCodes = Arrays.asList("ATH", "DUS", "CHI", "SAO", "HEL", "VIE",
            "BER", "BOG", "LTN", "JFK", "MEL", "KRK", "PAR", "LIS", "SEL", "GDN", "OSL",
            "ROM", "YTO", "MAD", "TYO", "SIN", "WAW", "BCN", "STO", "AMS", "BRU", "SYD", "IST", "OPO", "SVQ", "MRS",
            "MIL", "CPH", "PRG", "MEX", "MAR").stream().sorted().toList();

    private final Map<String, String> cities = IntStream.range(0, cityNames.size()).boxed().collect(Collectors.toMap(i -> cityNames.stream().sorted().toList().get(i), i -> cityCodes.stream().sorted().toList().get(i)));

    public FlightController(FlightServiceImpl flightService) {
        this.flightService = flightService;
    }
/*
    @GetMapping("/flight/list")
    public String showFlights(Model model, HttpSession session) {
        return "flightSummary";
    }
*/
    @GetMapping("/search/{planId}")
    public String findANewFlight(Model model, @PathVariable("planId") Integer planId, HttpSession session) {
        session.removeAttribute("departureCity");
        System.out.println("XDDD");
        session.setAttribute("cityNames", cityNames);
        model.addAttribute("flightDto", new FlightDto());
        return "flightSearch";
    }

    @PostMapping("/search/{planId}")
    public String findANewFlight(Model model, @PathVariable("planId") Integer planId, @Valid @ModelAttribute("flight") FlightDto flightDto, BindingResult result, HttpSession session) {
        System.out.println(flightDto.getDepartureCity() + "DP");
        if (flightDto.getArrivalCity() == null) {
            session.setAttribute("departureCity", flightDto.getDepartureCity());
            model.addAttribute("flightDto", flightDto);
            System.out.println(flightDto.getArrivalCity() + "AP");
            return "flightSearch";
        }

        if (flightDto.getDepartureDate() == null) {
            session.setAttribute("arrivalCity", flightDto.getArrivalCity());
            model.addAttribute("flightDto", flightDto);
            System.out.println(flightDto.getArrivalCity());
            return "flightSearch";
        }

        else {
            System.out.println("hahaha");
            if (result.hasErrors()) {
                result.getFieldErrors();
                return "redirect:/flight/search/".concat(planId.toString());
            }
            session.setAttribute("departureDateSession", flightDto.getArrivalCity());
            FlightDto flight = new FlightDto(session.getAttribute("departureCity").toString(), session.getAttribute("arrivalCity").toString(), flightDto.getDepartureDate());
        }
        System.out.println("XDD");
        return "/plan/details/".concat(planId.toString());
        //return "flightSearch";
    }

    @GetMapping("/resetForm/{planId}")
    public String resetAddingForm(HttpSession session, @PathVariable("planId") Integer planId) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        session.removeAttribute("departureCity");
        session.removeAttribute("arrivalCity");
        session.setAttribute("loggedUser", loggedUser);
        return "redirect:/plan/details/".concat(planId.toString());
    }

}
