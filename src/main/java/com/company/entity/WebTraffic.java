package com.company.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Component
public class WebTraffic {
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date date;
    @OneToOne
    private User user;
    @Id
    @GeneratedValue
    private Long id;

    public WebTraffic() {
        this.date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        ;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
