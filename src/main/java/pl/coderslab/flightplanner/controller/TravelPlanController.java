package pl.coderslab.flightplanner.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.flightplanner.entity.Flight;
import pl.coderslab.flightplanner.entity.TravelPlan;
import pl.coderslab.flightplanner.entity.TravelPlanDto;
import pl.coderslab.flightplanner.entity.User;
import pl.coderslab.flightplanner.service.TravelPlanService;
import pl.coderslab.flightplanner.service.TravelPlanServiceImpl;
import pl.coderslab.flightplanner.service.UserServiceImpl;

import java.util.List;

@Controller
public class TravelPlanController {

    @Autowired
    private final TravelPlanServiceImpl travelPlanService;

    @Autowired
    private final UserServiceImpl userService;

    public TravelPlanController(TravelPlanServiceImpl travelPlanService, UserServiceImpl userService) {
        this.travelPlanService = travelPlanService;
        this.userService = userService;
    }

    @GetMapping("/plan/add")
    public String showTravelPlanForm(Model model, HttpSession session) {
        model.addAttribute("travelPlan", new TravelPlanDto());
        return "travelPlanAdd";
    }

    @PostMapping("/plan/add")
    public String addTravelPlan(Model model, @Valid @ModelAttribute("travelPlan") TravelPlanDto travelPlanDto, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            result.getFieldErrors();
            System.out.println(result.hasErrors());
            return "travelPlanAdd";
        }
        TravelPlan travelPlan = new TravelPlan(travelPlanDto.getName(), travelPlanDto.getStartDate(), (User) session.getAttribute("loggedUser"), null);
        travelPlanService.save(travelPlan);
        return "redirect:/plan/details/".concat(Integer.toString(travelPlan.getId()));
    }

    @GetMapping("/plan/details/{travelPlanId}")
    public String showTravelDetails(Model model, @RequestParam("action") String action, @PathVariable("travelPlanId") Integer travelPlanId) {
        if (action.equals("newFlight")) {
            System.out.println("lol");
            return "redirect:/flight/search/".concat(travelPlanId.toString());
        } else {

            TravelPlan travelPlan = travelPlanService.findById(travelPlanId);
            model.addAttribute("travelPlan", travelPlan);
            return "travelPlanDetails";

        }

    }

    @GetMapping("/plan/edit/{travelPlanId}")
    public String showTravelEditForm(Model model, @PathVariable("travelPlanId") Integer travelPlanId) {
        TravelPlan travelPlan = travelPlanService.findById(travelPlanId);
        model.addAttribute("travelPlan", travelPlan);
        model.addAttribute("travelPlanDto", new TravelPlanDto());
        return "travelPlanEdit";
    }

    @PostMapping("/plan/edit/{travelPlanId}")
    public String editTravelPlan(Model model, @PathVariable("travelPlanId") Integer travelPlanId, @Valid @ModelAttribute("travelPlanDto") TravelPlanDto travelPlanDto, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            result.getFieldErrors();
            System.out.println(result.hasErrors());
            return "redirect:/plan/edit/".concat(travelPlanId.toString());
        }
        TravelPlan travelPlan = travelPlanService.findById(travelPlanId);
        travelPlan.setName(travelPlanDto.getName());
        travelPlan.setStartDate(travelPlanDto.getStartDate());
        travelPlanService.update(travelPlan);
        System.out.println(travelPlan.toString());
        return "redirect:/plan/details/".concat(Integer.toString(travelPlan.getId()));
    }


    @RequestMapping("/plan/list")
    public String showTravelPlan(Model model, HttpSession session) {
        List<TravelPlan> allTravels = travelPlanService.getTravelPlans(session);
        System.out.println(allTravels.toString());
        model.addAttribute("allPlans", allTravels);
        return "travelPlanList";
    }

    @PostMapping("/plan/removed/{travelPlanId}")
    public String removedTravelPlan(Model model, @PathVariable("travelPlanId") Integer travelPlanId) {
        TravelPlan travelPlan = travelPlanService.findById(travelPlanId);
        model.addAttribute("travelPlan", travelPlan);
        travelPlanService.delete(travelPlanService.findById(travelPlanId));
        return "travelPlanRemoved";
    }

}
