package com.examly.springapp.web.controller;

import com.examly.springapp.model.Courses;
import com.examly.springapp.model.Institute;
import com.examly.springapp.service.AdminService;
import com.examly.springapp.service.CoursesService;
import com.examly.springapp.service.InstituteService;
import com.examly.springapp.web.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    CoursesService coursesService;
    @Autowired
    InstituteService instituteService;

    @GetMapping("/admin/dashboard")
    @ResponseBody
    public String adminDashboard(){
        return "Welcome to admin Dashboard";
    }

    @PostMapping("/admin/signup")
    @ResponseBody
    public String registerAdminAccount(@Valid @RequestBody AdminRegistrationDto adminRegistrationDto){
        adminService.save(adminRegistrationDto);
        return "Admin Saved";
    }

    @PostMapping("/admin/addCourse")
    @ResponseBody
    public String addCourse(@RequestBody CourseSaveDto courseSaveDto){
                coursesService.saveCourse(courseSaveDto);
                return "Course Saved";
    }
    @PostMapping("/admin/addInstitute")
    @ResponseBody
    public String addCourse(@RequestBody InstituteSaveDto instituteSaveDto){
        instituteService.saveInstitute(instituteSaveDto);
        return "Institute Saved";
    }

    @GetMapping("/admin/viewInstitutes")
    @ResponseBody
    public List<Institute> viewInstitutes(){
       return  instituteService.getAllInstitutes();
    }

    @GetMapping("admin/viewInstitute")
    @ResponseBody
    public Institute viewInstitute(@RequestParam("instituteId") long instituteId){

        return instituteService.getInstituteById(instituteId);

    }

    @PutMapping("/admin/editInstitute")
    @ResponseBody
    public String editInstitute(@RequestBody InstituteSaveDto dto, @RequestParam("instituteId") long id ){
        instituteService.editInstitute(id,dto);
        return "Institute Edited";
    }

    @DeleteMapping("/admin/deleteInstitute")
    @ResponseBody
    String deleteInstitute(@RequestParam("instituteId") long id){
        instituteService.deleteInstitute(id);
        return "Institute Deleted";
    }

    @GetMapping("/admin/viewCourses")
    @ResponseBody
    public List<GetAllCoursesAdminDto> viewCourses(){
        return coursesService.getAllCourses();
    }

    @GetMapping("/admin/viewCourse")
    @ResponseBody
    public ViewCourseDto viewCourse(@RequestParam("courseId") long id){
        return coursesService.getCourseById(id);
    }

    @PutMapping("/admin/editCourse")
    @ResponseBody
    public String editCourse(@RequestParam("courseId") long id,@RequestBody ViewCourseDto dto){
          coursesService.editCourse(id,dto);
          return "Course Edited";
    }

    @DeleteMapping("/admin/deleteCourse")
    @ResponseBody
    public String deleteCourse(@RequestParam("courseId") long id){
              coursesService.deleteCourse(id);
        return "Course Deleted";
    }


}
