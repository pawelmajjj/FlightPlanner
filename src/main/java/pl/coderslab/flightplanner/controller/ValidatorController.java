package pl.coderslab.flightplanner.controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.flightplanner.entity.User;

import java.util.Set;

public class ValidatorController {

    private final Validator validator;

    public ValidatorController(Validator validator) {
        this.validator = validator;
    }

    /*
    @RequestMapping("/validate")
    public String validateUser(Model model, @ModelAttribute("user") User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if(!violations.isEmpty()) {
            for(ConstraintViolation<User> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
            }
            return "redirect:/user/login/";
        } else {
            return "index";
        }
    }*/

}
