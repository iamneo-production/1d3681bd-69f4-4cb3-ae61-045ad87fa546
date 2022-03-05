package com.examly.springapp.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
@Entity
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long userId;
    @Email
    @NotBlank
    @Column(name = "email")
    private String email;
    @NotBlank
    @Column(name = "userName")
    private String userName;
    @Digits(integer=10,fraction=0)
    @Column(name = "userMobileNumber")
    private String userMobileNumber;
    @Column(name = "userPassword")
    private String userPassword;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "userId",referencedColumnName = "userId"),
            inverseJoinColumns =@JoinColumn(name="roleId",referencedColumnName = "id"))
    private Collection<Role> roles;

    public User(String email, String userName, String userMobileNumber, String userPassword, Collection<Role> roles) {
        this.email = email;
        this.userName = userName;
        this.userMobileNumber = userMobileNumber;
        this.userPassword = userPassword;
        this.roles = roles;
    }

    public User() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String userEmail) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
