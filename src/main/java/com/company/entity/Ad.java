package com.company.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Component
@Entity
@Table(name = "AD")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long adId;
    @Column(name = "CONTENT", columnDefinition = "varchar(255) default 'not defined'")
    @NotBlank(message = "Please fill the message")
    @Length(max = 2048, message = "Message too long (more than 2kB)")
    private String textContent;
    @Column(name = "LOCATION" , columnDefinition = "varchar(255) default 'not defined'" )
    private String location;
    @Column(name = "ADDRESS" , columnDefinition = "varchar(255) default 'not defined'")
    private String address;
    @Column(name = "AD_PHONE_NUMBER" , columnDefinition = "varchar(255) default 'not defined'")
    @NotBlank(message = "Phone number cannot be empty")
    private String adPhoneNumber;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "AVAILABLE", columnDefinition = "boolean default false", nullable = false)
    private Boolean available = false;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private User user;
    @OneToOne
    private AdCategory adCategory;
    @Column(name = "AD_DAYS_ALIVE")
    private Integer adDaysAlive;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<UploadFile> uploadFile;

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long age) {
        this.adId = age;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String content) {
        this.textContent = content;
    }

    public Ad() {

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Set<UploadFile> getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(Set<UploadFile> uploadFile) {
        this.uploadFile = uploadFile;
    }


    public String getAdPhoneNumber() {
        return adPhoneNumber;
    }

    public void setAdPhoneNumber(String publicPhoneNumber) {
        this.adPhoneNumber = publicPhoneNumber;
    }

    public AdCategory getAdCategory() {
        return adCategory;
    }

    public void setAdCategory(AdCategory adCategory) {
        this.adCategory = adCategory;
    }

    public Integer getAdDaysAlive() {
        return adDaysAlive;
    }

    public void setAdDaysAlive(Integer adDaysAlive) {
        this.adDaysAlive = adDaysAlive;
    }

    public int getNumberOfFiles() {
        int i = 0;
        byte n;
        for (UploadFile upload : this.uploadFile) {
            if (!upload.getFileName().equals("")) {
                i++;
            }
        }
        return i;
    }
}
