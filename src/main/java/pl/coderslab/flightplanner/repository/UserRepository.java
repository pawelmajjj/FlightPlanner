package pl.coderslab.flightplanner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.flightplanner.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
