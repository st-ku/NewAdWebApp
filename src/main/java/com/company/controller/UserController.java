package com.company.controller;

import com.company.entity.User;
import com.company.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user_profile")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String updateUser(@PathVariable("id") User user, Model model) {
        model.addAttribute("user", user);
        return "user_profile";
    }

    @PostMapping
    public String updateUser(@Valid User user,
                             BindingResult bindingResult,
                             Model model) {
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            model.addAttribute("passwordConfirmError", "Password isn't match");
            return "user_profile";
        }
        if (bindingResult.hasErrors()) {
            return "user_profile";
        }
        userService.updateUser(user);
        return "redirect:/";
    }
}
