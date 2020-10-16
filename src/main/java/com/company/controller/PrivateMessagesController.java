package com.company.controller;

import com.company.entity.PrivateMessage;
import com.company.entity.User;
import com.company.service.PrivateMessageService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/private_messages")
public class PrivateMessagesController {

    private PrivateMessageService privateMessageService;

    public PrivateMessagesController(PrivateMessageService privateMessageService) {
        this.privateMessageService = privateMessageService;
    }

    @GetMapping("/view/{id}")
    public String messagesList(@AuthenticationPrincipal User user, @PathVariable("id") User fromUser, Model model) {
        if (privateMessageService.getAllInboxMessagesFromUser(fromUser.getId(),user.getId()).isEmpty()){
            model.addAttribute("messagesListError", "No messages");
            return "private_messages";
        }
        else
            model.addAttribute("messagesList", privateMessageService.getAllInboxMessagesFromUser(fromUser.getId(),user.getId()));
        return "private_messages";
    }
    @GetMapping("/new/{id}")
    public String newMessage(@AuthenticationPrincipal User fromUser, @PathVariable("id") User toUser,  Model model) {
        model.addAttribute("fromUser", fromUser);
        model.addAttribute("toUser", toUser);
        return "new_message";
    }
    @GetMapping("/dialogs/")
    public String userDialogs(@AuthenticationPrincipal User toUser,  Model model) {
        model.addAttribute("userList", privateMessageService.getAllUsersWhoWrote(toUser.getId()));
        model.addAttribute("messagesList", privateMessageService.getTotalInboxMessages(toUser.getId()));
        return "dialogs";
    }
    @PostMapping
    public String sendMessage(@RequestParam("toUserId") User toUser,@AuthenticationPrincipal User fromUser, @Valid PrivateMessage privateMessage) {
        privateMessageService.sendMessage(fromUser, toUser , privateMessage);
        return "redirect:/private_messages/dialogs/";
    }
}
