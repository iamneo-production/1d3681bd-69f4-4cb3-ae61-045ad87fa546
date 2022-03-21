package com.examly.springapp.web.controller;

import com.examly.springapp.service.AdmissionService;
import com.examly.springapp.service.CoursesService;
import com.examly.springapp.web.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CourseController {

    @Autowired
    CoursesService coursesService;
    @Autowired
    AdmissionService admissionService;

    @PostMapping("**/addCourse")
    @ResponseBody
    public String addCourse(@RequestBody CourseSaveDto courseSaveDto){
        coursesService.saveCourse(courseSaveDto);
        return "Course Saved";
    }

    @GetMapping("**/viewCourses")
    @ResponseBody
    public List<GetAllCoursesAdminDto> viewCourses(){
        return coursesService.getAllCourses();

    }

    @GetMapping("**/viewCourse")
    @ResponseBody
    public ViewCourseDto viewCourse(@RequestParam("courseId") long id){
        return coursesService.getCourseById(id);

    }

    @PutMapping("**/editCourse")
    @ResponseBody
    public String editCourse(@RequestParam("courseId") long id,@RequestBody ViewCourseDto dto){
        coursesService.editCourse(id,dto);
        return "Course Edited";
    }

    @DeleteMapping("**/deleteCourse")
    @ResponseBody
    public String deleteCourse(@RequestParam("courseId") long id){
        coursesService.deleteCourse(id);
        return "Course Deleted";
    }




}
