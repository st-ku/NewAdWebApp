package com.company.controller;

import com.company.captcha.CaptchaService;
import com.company.captcha.CaptchaSettings;
import com.company.entity.User;
import com.company.service.UserService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class RegistrationController {

    private UserService userService;
    private CaptchaService captchaService;

    public RegistrationController(UserService userService, CaptchaService captchaService, CaptchaSettings captchaSettings, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.captchaService = captchaService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@RequestParam("g-recaptcha-response") String gRecaptchaResponse, @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!captchaService.verify(gRecaptchaResponse)) {
            model.addAttribute("captchaError", "Captcha Error, try again");
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            model.addAttribute("passwordConfirmError", "Password isn't match");
            return "registration";
        }
        EmailValidator validator = EmailValidator.getInstance();
        if (!validator.isValid(userForm.getEmail())) {
            model.addAttribute("emailError", "Wrong Email");
            return "registration";
        }
        if (!userService.saveUser(userForm)) {
            model.addAttribute("usernameError", "User with this Username Already Exists");
            return "registration";
        }


        return "redirect:/";
    }
}
