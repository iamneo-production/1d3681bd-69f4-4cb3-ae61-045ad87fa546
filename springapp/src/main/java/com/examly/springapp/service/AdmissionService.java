package com.examly.springapp.service;

import com.examly.springapp.model.Admission;
import com.examly.springapp.web.dto.AdmissionAddressDto;
import com.examly.springapp.web.dto.GetAllAdmissionRequestDto;
import com.examly.springapp.web.dto.GetAllAppliedAdmissionDto;
import com.examly.springapp.web.dto.AdmissionSaveDto;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface AdmissionService {

    public void saveAdmission(AdmissionAddressDto dto, Authentication auth);

    public List<GetAllAppliedAdmissionDto> getAllAppliedCourses(Authentication auth);

    public List<GetAllAdmissionRequestDto> getAllAdmissionRequests();

    public String acceptAdmission(long admissionId);

    public String denyAdmission(long admissionId);

    public List<GetAllAdmissionRequestDto> getAllAcceptedAdmission();

    public List<GetAllAdmissionRequestDto> getAllDeniedAdmission();

    public AdmissionAddressDto getAdmissionById(long admissionId);

    public String editAdmission(AdmissionAddressDto dto,long admissionId);

    public String deleteAdmission(long admissionId);


}
