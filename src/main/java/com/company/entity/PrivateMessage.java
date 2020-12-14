package com.company.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Component
public class PrivateMessage {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;
    private String messageText;
    @OneToOne
    private User fromUser;
    @OneToOne
    private User toUser;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(columnDefinition = "boolean default false")
    private Boolean isViewed = false;

    public Boolean getViewed() {
        return isViewed;
    }

    public void setViewed(Boolean viewed) {
        isViewed = viewed;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUserId) {
        this.fromUser = fromUserId;
    }

    public void setToUser(User toUserId) {
        this.toUser = toUserId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
