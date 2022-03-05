package com.examly.springapp.service;

import com.examly.springapp.web.dto.CourseSaveDto;
import com.examly.springapp.web.dto.GetAllCoursesAdminDto;
import com.examly.springapp.web.dto.GetAllCoursesDto;
import com.examly.springapp.web.dto.ViewCourseDto;

import java.util.List;

public interface CoursesService {
    String saveCourse(CourseSaveDto courseSaveDto);

    List<GetAllCoursesDto> getAllCourses(Long instituteId);

    List<GetAllCoursesAdminDto> getAllCourses();

    ViewCourseDto getCourseById(long id);

    void editCourse(long id, ViewCourseDto dto);

    void deleteCourse(long id);
}
