package com.examly.springapp.web.dto;

import com.examly.springapp.constants.Constants;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserRegistrationDto {

   @Email
   @NotEmpty
    private String email;
   @NotEmpty
   @Pattern(regexp = Constants.USER_NAME_REGEX_VALIDATION)
   private String userName;
   @NotEmpty
   @Pattern(regexp = Constants.USER_MOBILE_REGEX_VALIDATION)
   private String userMobileNumber;
   @NotEmpty
   private String userPassword;
   @NotEmpty
   private String userRetypePassword;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String email, String userName, String userMobileNumber, String userPassword, String userRetypePassword) {
        this.email = email;
        this.userName = userName;
        this.userMobileNumber = userMobileNumber;
        this.userPassword = userPassword;
        this.userRetypePassword = userRetypePassword;
    }

    public UserRegistrationDto(String email, String userPassword) {
        this.email = email;
        this.userPassword = userPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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

    public String getUserRetypePassword() {
        return userRetypePassword;
    }

    public void setUserRetypePassword(String userRetypePassword) {
        this.userRetypePassword = userRetypePassword;
    }
}
