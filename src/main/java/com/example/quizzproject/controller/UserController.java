package com.example.quizzproject.controller;

import com.example.quizzproject.entity.User;
import com.example.quizzproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@SessionAttributes({"user"})
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("/signUp")
    public String signUpGet() {
        return "signUp";
    }

    @PostMapping("/signUp")
    public String SignUpPost(@RequestParam String email, HttpServletRequest req, @RequestParam String name, @RequestParam String password) {
       userService.createUser(name, email, password);
        HttpSession newSession = req.getSession(true);
        newSession.setAttribute("user", userService.getUserByEmail(email));
        newSession.setMaxInactiveInterval(300);
       return "redirect:/";
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(Model model, HttpServletRequest req, @RequestParam String email, @RequestParam String password) {
        if (userService.authenticateUser(email, password)) {
            HttpSession oldSession = req.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession newSession = req.getSession(true);
            newSession.setAttribute("user", userService.getUserByEmail(email));
            newSession.setMaxInactiveInterval(300);
            return "redirect:/";
        } else {
            model.addAttribute("exception", "Email or password invalid");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest req, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
