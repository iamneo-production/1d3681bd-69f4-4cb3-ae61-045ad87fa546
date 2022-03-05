package com.examly.springapp.service;

import com.examly.springapp.web.dto.GetAllAppliedCoursesDto;
import com.examly.springapp.web.dto.StudentSaveDto;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface StudentService {

    public void saveStudent(StudentSaveDto dto, Authentication auth);

    public List<GetAllAppliedCoursesDto> getAllAppliedCourses(Authentication auth);


}
