package pl.coderslab.flightplanner.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.flightplanner.entity.UserDto;
import pl.coderslab.flightplanner.entity.User;
import pl.coderslab.flightplanner.service.UserServiceImpl;


@Controller
@RequestMapping("/user")
//@SessionAttributes("loggedUser")
public class UserController {
    @Autowired
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }



    @GetMapping("/register")
    public String showRegisterForm(Model model, HttpSession session) {
        session.removeAttribute("errorMessage");
        if (session.getAttribute("loggedUser") != null) {
            return "/";
        }
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register")
    public String registerForm(Model model, @Valid @ModelAttribute("user") UserDto userDTO, BindingResult result, HttpSession session) {

        if (result.hasErrors()) {
            result.getFieldErrors();
            return "register";
        }

        User user = new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getBirthDate(),
                userDTO.getEmail().toLowerCase(), BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt()));

        if (userService.findByEmail(user.getEmail()) !=null) {
            session.setAttribute("errorMessage", "This e-mail address is already registered.");
            return "register";
        }

        userService.add(user);
        session.removeAttribute("errorMessage");
        return "login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model, HttpSession session) {
        session.removeAttribute("errorMessage");
        if (session.getAttribute("loggedUser") != null) {
            return "redirect:/plan/list";
        }
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String LoginForm(Model model, @Valid @ModelAttribute("user") User user, HttpSession session) {

        if (userService.authenticate(user) != null) {
            session.removeAttribute("errorMessage");
            session.setAttribute("loggedUser", user);
            return "redirect:/plan/list";
        } else {
            session.setAttribute("errorMessage", "The e-mail or password you entered is incorrect.");
            System.out.println(session.getAttribute("errorMessage"));
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loggedUser");
        return "index";
    }

}
