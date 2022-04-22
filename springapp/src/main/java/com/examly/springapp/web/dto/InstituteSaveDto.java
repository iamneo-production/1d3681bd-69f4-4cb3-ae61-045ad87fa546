package com.examly.springapp.web.dto;
import com.examly.springapp.constants.Constants;

import javax.validation.constraints.*;

import javax.validation.constraints.Email;

public class InstituteSaveDto {


   @NotEmpty
    @Pattern(regexp = Constants.INSTITUTE_NAME_REGEX_VALIDATION)
    private String instituteName;
    @NotEmpty
    @Pattern(regexp =Constants.INSTITUTE_DESCRIPTION_REGEX_VALIDATION )
    private String instituteDescription;
    @NotEmpty
    @Pattern(regexp = Constants.INSTITUTE_CITY_REGEX_VALIDATION)
    private String instituteCity;
    @NotEmpty
    @Pattern(regexp = Constants.INSTITUTE_STATE_REGEX_VALIDATION)
    private String instituteState;
    @NotEmpty
    @Email
    private String instituteEmail;
    @NotEmpty
    @Size(min=10,max=10)
    @Pattern(regexp = Constants.INSTITUTE_MOBILE_NUMBER_REGEX_VALIDATION)
    private String instituteMobile;
    @NotNull
    private Integer nirfRank;

    public InstituteSaveDto() {
    }

    public InstituteSaveDto(String instituteName, String instituteDescription, String instituteCity, String instituteState, String instituteEmail, String instituteMobile, int nirfRank) {
        this.instituteName = instituteName;
        this.instituteDescription = instituteDescription;
        this.instituteCity = instituteCity;
        this.instituteState = instituteState;
        this.instituteEmail = instituteEmail;
        this.instituteMobile = instituteMobile;
        this.nirfRank = nirfRank;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getInstituteDescription() {
        return instituteDescription;
    }

    public void setInstituteDescription(String instituteDescription) {
        this.instituteDescription = instituteDescription;
    }

    public String getInstituteCity() {
        return instituteCity;
    }

    public void setInstituteCity(String instituteCity) {
        this.instituteCity = instituteCity;
    }

    public String getInstituteState() {
        return instituteState;
    }

    public void setInstituteState(String instituteState) {
        this.instituteState = instituteState;
    }

    public String getInstituteEmail() {
        return instituteEmail;
    }

    public void setInstituteEmail(String instituteEmail) {
        this.instituteEmail = instituteEmail;
    }

    public String getInstituteMobile() {
        return instituteMobile;
    }

    public void setInstituteMobile(String instituteMobile) {
        this.instituteMobile = instituteMobile;
    }

    public int getNirfRank() {
        return nirfRank;
    }

    public void setNirfRank(int nirfRank) {
        this.nirfRank = nirfRank;
    }
}
