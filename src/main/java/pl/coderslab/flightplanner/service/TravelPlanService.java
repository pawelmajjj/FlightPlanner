package pl.coderslab.flightplanner.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import pl.coderslab.flightplanner.entity.Flight;
import pl.coderslab.flightplanner.entity.TravelPlan;

import java.util.List;

@Service
public interface TravelPlanService {
    public List<TravelPlan> getTravelPlans(HttpSession session);
    public void save(TravelPlan travelPlan);
    public void update(TravelPlan travelPlan);
    public TravelPlan findById(Integer id);
    public void delete(TravelPlan travelPlan);
}
