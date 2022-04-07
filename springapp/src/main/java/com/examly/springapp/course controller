package com.examly.springapp.web.controller;

import com.examly.springapp.model.Courses;
import com.examly.springapp.service.CoursesService;
import com.examly.springapp.web.dto.CourseSaveDto;
import com.examly.springapp.web.dto.GetAllCoursesAdminDto;


import com.examly.springapp.web.dto.GetAllCoursesDto;
import com.examly.springapp.web.dto.ViewCourseDto;
import exception.ResourceNotFound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class CourseController {
    @Autowired
    CoursesService coursesService;


    @PostMapping("/**/addCourse")
    @ResponseBody
    public ResponseEntity<?> addCourse(@RequestBody CourseSaveDto courseSaveDto){

    		Courses c= coursesService.saveCourse(courseSaveDto);
    		return new ResponseEntity<Courses>(c,HttpStatus.CREATED);


    }

    
    @GetMapping("/**/viewCourses")
    @ResponseBody
    public List<GetAllCoursesAdminDto> viewCourses(){
       List<GetAllCoursesAdminDto> s=coursesService.getAllCourses();
        return s;
    	
    }

    @GetMapping("/**/viewCourse/{courseId}")
    @ResponseBody
    public ViewCourseDto viewCourse(@PathVariable("courseId") long courseId){

       ViewCourseDto s= coursesService.getCourseById(courseId);
      return s;

    }
    

    @PutMapping("/**/editCourse/{courseId}")
    @ResponseBody
    public String editCourse(@RequestBody CourseSaveDto dto, @PathVariable("courseId") long id ){
        coursesService.editCourse(id,dto);
        return "Course Edited";
    }
    

    @DeleteMapping("/**/deleteCourse/{courseId}")
    @ResponseBody
   public  String deleteCourse(@PathVariable("courseId") long id){
    	
    	if(coursesService.getCourseById(id)==null)
    		throw new ResourceNotFound("Course not found to be deleted");
    	 coursesService.deleteCourse(id);
    	      return "Course deleted";  	
        
    }

}
