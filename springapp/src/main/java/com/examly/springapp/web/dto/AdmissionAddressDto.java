package com.examly.springapp.web.dto;
import com.examly.springapp.constants.Constants;

import javax.validation.constraints.*;

public class AdmissionAddressDto {

   @NotNull(message = Constants.USER_ID_VALIDATION)
    @Positive
    @Digits(integer = 10,fraction = 0)
    private Long userId;
    @NotNull(message = Constants.COURSE_ID_VALIDATION)
    @Positive
    @Digits(integer = 10,fraction = 0)
    private Long courseId;
    @NotEmpty(message = Constants.FIRST_NAME_NON_EMPTY_VALIDATION)
    @Pattern(regexp = Constants.FIRST_NAME_REGEX_VALIDATION,message = Constants.FIRST_NAME_VALIDATION)
    @Size(min=1,max = 1000)
    private String firstName;
    @NotEmpty(message = Constants.LAST_NAME_NON_EMPTY_VALIDATION)
    @Pattern(regexp = Constants.LAST_NAME_REGEX_VALIDATION,message = Constants.LAST_NAME_VALIDATION)
    @Size(min=1,max = 1000)
    private String lastName;
    @NotEmpty(message = Constants.EMAIL_EMPTY_VALIDATION)
    @Email(message = Constants.EMAIL_VALIDATION)
    private String email;
    @NotEmpty(message = Constants.MOBILE_EMPTY_VALIDATION)
    @Size(min=10,max=10,message = Constants.MOBILE_NUMBER_SIZE_VALIDATION)
    @Pattern(regexp = Constants.MOBILE_NUMBER_REGEX_VALIDATION,message = Constants.MOBILE_NUMBER_VALIDATION)
    private String mobile;
    @NotEmpty(message = Constants.GENDER_EMPTY_VALIDATION)
    private String gender;
    @NotEmpty(message = Constants.FATHER_NAME_NON_EMPTY_VALIDATION)
    @Pattern(regexp = Constants.FATHER_NAME_REGEX_VALIDATION,message = Constants.FATHER_NAME_VALIDATION)
    @Size(min=1,max = 1000)
    private String fatherName;
    @NotEmpty(message = Constants.MOTHER_NAME_NON_EMPTY_VALIDATION)
    @Pattern(regexp = Constants.MOTHER_NAME_REGEX_VALIDATION,message = Constants.MOTHER_NAME_VALIDATION)
    @Size(min=1,max = 1000)
    private String motherName;
    @NotEmpty(message = Constants.AGE_EMPTY_VALIDATION)
    @Pattern(regexp = Constants.AGE_REGEX_VALIDATION,message = Constants.AGE_VALIDATION)
    private String age;
    @NotEmpty(message = Constants.HSC_NAME_EMPTY_VALIDATION)
    @Pattern(regexp = Constants.HSC_NAME_REGEX_VALIDATION,message = Constants.HSC_NAME_VALIDATION)
    private String hscName;
    @NotNull(message = Constants.HSC_MARKS_EMPTY_VALIDATION)
    @Digits(integer = 10,fraction = 0)
    private Long hscMarks;
    private String eligibility;

    //Address Details

   @NotEmpty(message = Constants.HOUSE_NUMBER_EMPTY_VALIDATION)
   @Pattern(regexp = Constants.HOUSE_NUMBER_REGEX_VALIDATION,message = Constants.HOUSE_NUMBER_VALIDATION)
    private String houseNumber;
    @NotEmpty(message = Constants.STREET_NUMBER_EMPTY_VALIDATION)
    @Pattern(regexp = Constants.STREET_NUMBER_REGEX_VALIDATION,message = Constants.STREET_NUMBER_VALIDATION)
   private String streetNumber;
    @NotEmpty(message = Constants.AREA_NAME_EMPTY_VALIDATION)
    @Pattern(regexp = Constants.AREA_NAME_REGEX_VALIDATION,message = Constants.AREA_NAME_VALIDATION)
    private String areaName;
    @NotEmpty(message = Constants.STATE_EMPTY_VALIDATION)
    @Pattern(regexp = Constants.STATE_REGEX_VALIDATION,message = Constants.STATE_VALIDATION)
    private String state;
    @NotEmpty(message = Constants.PINCODE_EMPTY_VALIDATION)
    @Pattern(regexp = Constants.PINCODE_REGEX_VALIDATION,message = Constants.PINCODE_VALIDATION)
    private String pinCode;
    @NotEmpty(message = Constants.NATIONALITY_EMPTY_VALIDATION)
    @Pattern(regexp = Constants.NATIONALITY_REGEX_VALIDATION,message = Constants.NATIONALITY_VALIDATION)
    private String nationality;

    public AdmissionAddressDto() {
    }

    public AdmissionAddressDto(long userId, long courseId, String firstName, String lastName, String email, String mobile, String gender, String fatherName, String motherName, String age, String hscName, long hscMarks, String eligibility, String houseNumber, String streetNumber, String areaName, String state, String pinCode, String nationality) {
        this.userId = userId;
        this.courseId = courseId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.age = age;
        this.hscName = hscName;
        this.hscMarks = hscMarks;
        this.eligibility = eligibility;
        this.houseNumber = houseNumber;
        this.streetNumber = streetNumber;
        this.areaName = areaName;
        this.state = state;
        this.pinCode = pinCode;
        this.nationality = nationality;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHscName() {
        return hscName;
    }

    public void setHscName(String hscName) {
        this.hscName = hscName;
    }

    public long getHscMarks() {
        return hscMarks;
    }

    public void setHscMarks(long hscMarks) {
        this.hscMarks = hscMarks;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
