package pl.coderslab.flightplanner.service;

import org.springframework.stereotype.Service;
import pl.coderslab.flightplanner.entity.Flight;
import pl.coderslab.flightplanner.entity.User;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAllUsers();
    public void add(User user);
    public void update(User user);
    public User findByEmail(String email);
    public void delete(String email);
    public User authenticate(User user);
    public User passwordCheck(String password, User foundUser);
}
