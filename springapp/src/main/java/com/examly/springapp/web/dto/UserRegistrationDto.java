package com.examly.springapp.web.dto;

import javax.validation.constraints.Email;

public class UserRegistrationDto {

    private String email;
    private String userName;
    private String userMobileNumber;
    private String userPassword;

    public UserRegistrationDto(String email, String userName, String userMobileNumber, String userPassword) {
        this.email = email;
        this.userName = userName;
        this.userMobileNumber = userMobileNumber;
        this.userPassword = userPassword;
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
}
