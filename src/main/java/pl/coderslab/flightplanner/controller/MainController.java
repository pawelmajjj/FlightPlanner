package pl.coderslab.flightplanner.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.flightplanner.entity.User;

@Controller
public class MainController {
/*
    @GetMapping("/*")
    public String ifNotLoggedIn(HttpSession session) {
        if(session.getAttribute("loggedUser") == null) {
            return "redirect:/index";
        }
        else {

        }
    }
    */

    @GetMapping("/")
    public String redirectToHome(HttpSession session) {
        if (session.getAttribute("loggedUser") != null) {
            return "redirect:/plan/list";
        }
        return "index";
    }
}
