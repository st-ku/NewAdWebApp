package com.company.service;

import com.company.entity.User;
import com.company.entity.WebTraffic;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service

public class UserListener {
    UserService userService;
    WebTrafficService webTrafficService;
    HttpSession session;

    public UserListener(UserService userService, WebTrafficService webTrafficService, HttpSession session) {
        this.userService = userService;
        this.webTrafficService = webTrafficService;
        this.session = session;
    }

    @EventListener
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
        UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
        User user = this.userService.findUserByName(userDetails.getUsername());
        WebTraffic webTraffic = new WebTraffic();
        user.setWebTraffic(webTraffic);
        userService.saveUser(user);
    }

}
