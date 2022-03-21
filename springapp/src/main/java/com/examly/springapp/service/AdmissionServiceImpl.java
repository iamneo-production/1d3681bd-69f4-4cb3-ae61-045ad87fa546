package com.examly.springapp.service;

import com.examly.springapp.model.*;
import com.examly.springapp.repository.*;
import com.examly.springapp.web.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdmissionServiceImpl implements AdmissionService {

    @Autowired
    AdmissionRepository admissionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CoursesRepository coursesRepository;
    @Autowired
    InstituteRepository instituteRepository;
    @Autowired
    AddressRepository addressRepository;


    @Override
    public void saveAdmission(AdmissionAddressDto dto, Authentication auth) {

        User user = userRepository.findByEmail(auth.getName());
        Courses course = coursesRepository.findByCourseId(dto.getCourseId());

       /* Courses newCourse = new Courses(course.getCourseName(),course.getCourseDescription(),
                course.getCourseDuration(),course.getCourseTiming(),course.getCourseStudentCount(),
                course.getCourseAcademicYear(),course.getCourseRequiredPercentage(),instituteRepository.findByInstituteId(course.getInstituteId()));
*/
        Admission admission = new Admission(dto.getFirstName(),dto.getLastName(),dto.getEmail(),
                dto.getMobile(),dto.getGender(),dto.getFatherName(),dto.getMotherName(),
                dto.getAge(),dto.getHscName(),dto.getHscMarks(),dto.getEligibility(),
                false,false,user,course);
        admissionRepository.save(admission);
        Address address = new Address(dto.getHouseNumber(),dto.getStreetNumber(),dto.getAreaName(),
                dto.getState(),dto.getPinCode(),dto.getNationality(),admission);

          addressRepository.save(address);



    }

    @Override
    public List<GetAllAppliedAdmissionDto> getAllAppliedCourses(Authentication auth) {
        User user=userRepository.findByEmail(auth.getName());

        List<Admission> studentList= admissionRepository.findByUserId(user.getUserId());
        ArrayList<GetAllAppliedAdmissionDto> list = new ArrayList<>();
        for(Admission student:studentList){

            Courses course = student.getCourse();
            Institute institute= course.getInstitute();
            GetAllAppliedAdmissionDto getAllAppliedAdmissionDto = new GetAllAppliedAdmissionDto(
                    student.getAdmissionId(),student.isAccepted(),student.isDenied(),
                    course.getCourseId(),course.getCourseName(),course.getCourseDescription(),
                    course.getCourseDuration(),course.getCourseTiming(),course.getCourseStudentCount(),
                    course.getCourseAcademicYear(),course.getCourseRequiredPercentage(),
                    institute.getInstituteName(),institute.getInstituteDescription(),
                    institute.getInstituteCity(),institute.getInstituteState(),institute.getInstituteEmail(),
                    institute.getInstituteMobile(),institute.getNirfRank()
            );
            list.add(getAllAppliedAdmissionDto);

        }

        return list;
    }

    @Override
    public List<GetAllAdmissionRequestDto> getAllAdmissionRequests() {
        List<GetAllAdmissionRequests> requestsList= admissionRepository.getAllAdmissionRequests();
         ArrayList<GetAllAdmissionRequestDto> list= new ArrayList<>();
        for(GetAllAdmissionRequests req:requestsList){
            Courses course = coursesRepository.findByCourseId(req.getCourseId());
            Institute institute= course.getInstitute();
            GetAllAdmissionRequestDto dto = new GetAllAdmissionRequestDto(req.getAdmissionId(),
                    req.getFirstName(),req.getLastName(),req.getEmail(),req.getMobile(),req.getGender(),
                    req.getFatherName(),req.getMotherName(),req.getAge(),req.getHscName(),req.getHscMarks(),
                    req.getEligibility(),req.getAccepted(), req.getDenied(), course.getCourseId(),course.getCourseName(),course.getCourseDescription(),
                    course.getCourseDuration(),course.getCourseTiming(),course.getCourseStudentCount(),
                    course.getCourseAcademicYear(),course.getCourseRequiredPercentage(),institute.getInstituteName(),
                    institute.getInstituteDescription(),institute.getInstituteCity(),institute.getInstituteState(),
                    institute.getInstituteEmail(),institute.getInstituteMobile(),institute.getNirfRank());

            list.add(dto);

        }
       return list;
    }

    @Override
    public String acceptAdmission(long admissionId) {
        admissionRepository.acceptAdmission(admissionId);
        return "Accepted";
    }

    @Override
    public String denyAdmission(long admissionId) {
        admissionRepository.denyAdmission(admissionId);
        return "Admission Denied";
    }

    @Override
    public List<GetAllAdmissionRequestDto> getAllAcceptedAdmission() {
        List<GetAllAdmissionRequests> requestsList= admissionRepository.getAllAcceptedAdmission();
        ArrayList<GetAllAdmissionRequestDto> list= new ArrayList<>();
        for(GetAllAdmissionRequests req:requestsList){
            Courses course = coursesRepository.findByCourseId(req.getCourseId());
            Institute institute= course.getInstitute();
            GetAllAdmissionRequestDto dto = new GetAllAdmissionRequestDto(req.getAdmissionId(),
                    req.getFirstName(),req.getLastName(),req.getEmail(),req.getMobile(),req.getGender(),
                    req.getFatherName(),req.getMotherName(),req.getAge(),req.getHscName(),req.getHscMarks(),
                    req.getEligibility(),req.getAccepted(), req.getDenied(), course.getCourseId(),course.getCourseName(),course.getCourseDescription(),
                    course.getCourseDuration(),course.getCourseTiming(),course.getCourseStudentCount(),
                    course.getCourseAcademicYear(),course.getCourseRequiredPercentage(),institute.getInstituteName(),
                    institute.getInstituteDescription(),institute.getInstituteCity(),institute.getInstituteState(),
                    institute.getInstituteEmail(),institute.getInstituteMobile(),institute.getNirfRank());

            list.add(dto);

        }
        return list;
    }

    @Override
    public List<GetAllAdmissionRequestDto> getAllDeniedAdmission() {
        List<GetAllAdmissionRequests> requestsList= admissionRepository.getAllDeniedAdmission();
        ArrayList<GetAllAdmissionRequestDto> list= new ArrayList<>();
        for(GetAllAdmissionRequests req:requestsList){
            Courses course = coursesRepository.findByCourseId(req.getCourseId());
            Institute institute= course.getInstitute();
            GetAllAdmissionRequestDto dto = new GetAllAdmissionRequestDto(req.getAdmissionId(),
                    req.getFirstName(),req.getLastName(),req.getEmail(),req.getMobile(),req.getGender(),
                    req.getFatherName(),req.getMotherName(),req.getAge(),req.getHscName(),req.getHscMarks(),
                    req.getEligibility(),req.getAccepted(), req.getDenied(), course.getCourseId(),course.getCourseName(),course.getCourseDescription(),
                    course.getCourseDuration(),course.getCourseTiming(),course.getCourseStudentCount(),
                    course.getCourseAcademicYear(),course.getCourseRequiredPercentage(),institute.getInstituteName(),
                    institute.getInstituteDescription(),institute.getInstituteCity(),institute.getInstituteState(),
                    institute.getInstituteEmail(),institute.getInstituteMobile(),institute.getNirfRank());

            list.add(dto);

        }
        return list;
    }

    @Override
    public AdmissionAddressDto getAdmissionById(long admissionId) {
        GetAllAdmissionRequests req= admissionRepository.getAdmissionById(admissionId);
        Address address = addressRepository.findByAdmissionId(admissionId);

        AdmissionAddressDto dto = new AdmissionAddressDto(req.getCourseId(),req.getFirstName(),
                req.getLastName(),req.getEmail(),req.getMobile(),req.getGender(),req.getFatherName(),
                req.getMotherName(),req.getAge(),req.getHscName(),req.getHscMarks(),req.getEligibility(),
                address.getHouseNumber(),address.getStreetNumber(),address.getAreaName(),address.getState(),
                address.getPinCode(),address.getNationality());






        return dto;
    }

    @Override
    public String editAdmission(AdmissionAddressDto dto,long admissionId) {

        admissionRepository.editAdmission(dto.getFirstName(),dto.getLastName(),dto.getEmail(),
                dto.getMobile(),dto.getGender(),dto.getFatherName(),dto.getMotherName(),
                dto.getAge(),dto.getHscName(),dto.getHscMarks(),dto.getEligibility(),admissionId);

        addressRepository.editAddress(dto.getHouseNumber(),dto.getStreetNumber(),dto.getAreaName(),
                dto.getState(),dto.getPinCode(),dto.getNationality(),admissionId);
        return "Admission Edited";
    }

    @Override
    public String deleteAdmission(long admissionId) {

        admissionRepository.deleteAdmission(admissionId);
        return "Admission Deleted";
    }


}