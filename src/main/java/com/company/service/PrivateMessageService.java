package com.company.service;

import com.company.entity.PrivateMessage;
import com.company.entity.User;
import com.company.repository.PrivateMessageRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PrivateMessageService {
   private PrivateMessageRepository privateMessageRepository;

    public PrivateMessageService(PrivateMessageRepository privateMessageRepository) {
        this.privateMessageRepository = privateMessageRepository;
    }

    public void sendMessage(User fromUser, User toUser, PrivateMessage privateMessage) {
        privateMessage.setCreationDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        privateMessage.setFromUser(fromUser);
        privateMessage.setToUser(toUser);
        privateMessageRepository.save(privateMessage);
     }
     public List<PrivateMessage> getTotalInboxMessages(Long toUserId) {
      return privateMessageRepository.findAllByToUser_Id(toUserId);
     }
    public List<PrivateMessage> getAllInboxMessagesFromUser(Long fromUserId, Long toUserId) {
        return privateMessageRepository.findAllByFromUser_IdAndToUser_Id(fromUserId,toUserId);
    }
    public Set<User> getAllUsersWhoWrote(Long userId) {
        HashSet<User> userList = new HashSet<>();
        for (PrivateMessage privateMessage:
        privateMessageRepository.findAllByToUser_Id(userId)) {
            userList.add(privateMessage.getFromUser());
        }
        return userList;
    }

}
