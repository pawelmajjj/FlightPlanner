package pl.coderslab.flightplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.flightplanner.entity.TravelPlan;

@Repository
public interface TravelPlanRepository extends JpaRepository<TravelPlan,Integer> {

}
