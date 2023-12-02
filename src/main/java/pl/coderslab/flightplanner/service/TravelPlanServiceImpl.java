package pl.coderslab.flightplanner.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.flightplanner.entity.TravelPlan;
import pl.coderslab.flightplanner.entity.User;

import java.util.List;

@Service
@Transactional
public class TravelPlanServiceImpl implements TravelPlanService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TravelPlan> getTravelPlans(HttpSession session) {
        String email = ((User) session.getAttribute("loggedUser")).getEmail();
        Query query = entityManager
                .createQuery("SELECT p FROM TravelPlan p WHERE p.owner.email = :email").setParameter("email", email);
        return query.getResultList();
    }

    @Override
    public void save(TravelPlan travelPlan) {
        entityManager.persist(travelPlan);
    }

    @Override
    public void update(TravelPlan travelPlan) {
        entityManager.merge(travelPlan);
    }


    @Override
    public TravelPlan findById(Integer id) {
        Query findTravelPlan = entityManager
                .createQuery("SELECT p FROM TravelPlan p WHERE p.id = :id")
                .setParameter("id", id);
        List<TravelPlan> travelPlans = findTravelPlan.getResultList();
        return travelPlans.size() > 0 ? travelPlans.get(0) : null;
    }

    @Override
    public void delete(TravelPlan travelPlan) {
        entityManager.remove(travelPlan);
    }
}
