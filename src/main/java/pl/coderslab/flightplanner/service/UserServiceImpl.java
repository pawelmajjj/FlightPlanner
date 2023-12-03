package pl.coderslab.flightplanner.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.flightplanner.entity.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {

        Query query = entityManager
                .createQuery("SELECT u FROM User u");
        return query.getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findByEmail(String email) {
        Query emailCheck = entityManager
                .createQuery("SELECT u FROM User u WHERE u.email = :email")
                .setParameter("email", email);
        List<User> users = emailCheck.getResultList();
        return users.size() > 0 ? users.get(0) : null;
    }


    @Override
    public void delete(String email) {
        entityManager.remove(email);
    }

    public User passwordCheck(String password, User foundUser) {
        if (foundUser != null) {
            if (BCrypt.checkpw(password, foundUser.getPassword())) {
                return foundUser;
            }
        }
        return null;
    }

    @Override
    public User authenticate(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        User foundUser = findByEmail(email); //we check if the user exists in the database
        return passwordCheck(password, foundUser);
    }

}