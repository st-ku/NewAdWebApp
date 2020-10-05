package com.company.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Component
@Entity
@Table(name = "USER_ENTITY")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Username cannot be empty")
    private String username;
    @NotBlank(message = "Password cannot be empty")
    private String password;
    @Transient
    @NotBlank(message = "Password cannot be empty")
    private String passwordConfirm;
    @Column(name = "EMAIL")
    @NotBlank(message = "Email cannot be empty")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Role role;
    @Column(name = "LAST_LOGIN_DATE")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Ad> userAds;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<WebTraffic> webTraffic;

    public User() {
        Role role = new Role();
        role.setId(3L);
        role.setName("ROLE_USER");
        this.role = role;
    }

    public List<WebTraffic> getWebTraffic() {
        return webTraffic;
    }

    public Date getLastLoginDate() {
        return !webTraffic.isEmpty() ? webTraffic.get(webTraffic.size() - 1).getDate() : new Date();
    }

    public void setWebTraffic(WebTraffic webTraffic) {
        this.webTraffic.add(webTraffic);
    }

    public List<Ad> getUserAds() {
        return userAds;
    }

    public void setUserAds(List<Ad> userAds) {
        this.userAds = userAds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getRole());
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Role getRole() {
        return role;
    }

    public void setNewRoles(Role role) {
        this.role = role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber.isEmpty() ? "0" : phoneNumber;

    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isManager() {

        return this.getRole().getName().equals("ROLE_MANAGER");
    }

    public boolean isAdmin() {
        return this.getRole().getName().equals("ROLE_ADMIN");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}