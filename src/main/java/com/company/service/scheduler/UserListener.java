package com.company.service.scheduler;

import com.company.entity.User;
import com.company.entity.WebTraffic;
import com.company.service.UserService;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service

public class UserListener {
    private UserService userService;

    public UserListener(UserService userService) {
        this.userService = userService;
    }

    @EventListener
    @Transactional
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
        UserDetails userDetails = (UserDetails) event.getAuthentication().getPrincipal();
        User user = (User) this.userService.loadUserByUsername(userDetails.getUsername());
        WebTraffic webTraffic = new WebTraffic();
        user.setWebTraffic(webTraffic);
        userService.saveNewUser(user);
    }

}
