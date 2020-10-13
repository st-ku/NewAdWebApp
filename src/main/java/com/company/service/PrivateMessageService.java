package com.company.service;

import com.company.entity.PrivateMessage;
import com.company.entity.User;
import com.company.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class PrivateMessageService {
    private UserRepository UserRepository;

    public PrivateMessageService(com.company.repository.UserRepository userRepository) {
        UserRepository = userRepository;
    }

    public void sendMessage(User fromUser, User toUser, PrivateMessage privateMessage) {
        privateMessage.setCreationDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        privateMessage.setFromUser(fromUser);
        toUser.addToPrivateMessagesList(privateMessage);
        UserRepository.save(toUser);
     }
}
