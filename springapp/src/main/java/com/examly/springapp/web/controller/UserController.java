package com.examly.springapp.web.controller;

import com.examly.springapp.model.Institute;
import com.examly.springapp.service.CoursesService;
import com.examly.springapp.service.InstituteService;
import com.examly.springapp.service.StudentService;
import com.examly.springapp.service.UserService;
import com.examly.springapp.web.dto.GetAllAppliedCoursesDto;
import com.examly.springapp.web.dto.GetAllCoursesDto;
import com.examly.springapp.web.dto.StudentSaveDto;
import com.examly.springapp.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;
    @Autowired
    InstituteService instituteService;
    @Autowired
    CoursesService coursesService;
   /* @GetMapping
    public String getPage(){
        return "registration";
    }*/

    @PostMapping("/user/signup")
    @ResponseBody
    public String registerUserAccount(@Valid @RequestBody UserRegistrationDto userRegistrationDto){
        userService.save(userRegistrationDto);
        return "User Saved";
    }
    @GetMapping("/user/dashboard")
    @ResponseBody
    public String adminDashboard(){
        return "Welcome to User Dashboard";
    }

    @PostMapping("/user/enroll")
    @ResponseBody
    public String enroll(@RequestBody StudentSaveDto studentSaveDto,Authentication auth){
        studentService.saveStudent(studentSaveDto,auth);
        return "Course Enrolled";
    }

    @GetMapping("/user/getAllAppliedCourses")
    @ResponseBody
    public List<GetAllAppliedCoursesDto> getAllAppliedCourses(Authentication auth){
        return studentService.getAllAppliedCourses(auth);

    }

    @GetMapping("user/getAllInstitutes")
    @ResponseBody
    public List<Institute> getAllInstitutes(){
       return instituteService.getAllInstitutes();
    }

    @GetMapping("user/getAllCourses")
    @ResponseBody
    public List<GetAllCoursesDto> getAllCourses(@RequestParam("instituteId") long instituteId){

        return coursesService.getAllCourses(instituteId);
    }




}
