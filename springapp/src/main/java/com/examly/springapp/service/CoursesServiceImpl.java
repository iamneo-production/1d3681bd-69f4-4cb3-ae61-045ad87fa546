package com.examly.springapp.service;

import com.examly.springapp.model.Courses;
import com.examly.springapp.model.Institute;
import com.examly.springapp.repository.CoursesRepository;
import com.examly.springapp.repository.InstituteRepository;
import com.examly.springapp.web.dto.CourseSaveDto;
import com.examly.springapp.web.dto.GetAllCoursesAdminDto;
import com.examly.springapp.web.dto.GetAllCoursesDto;
import com.examly.springapp.web.dto.ViewCourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesServiceImpl implements CoursesService{
    @Autowired
    CoursesRepository coursesRepository;
    @Autowired
    InstituteRepository instituteRepository;
    @Override
    public String saveCourse(CourseSaveDto dto) {
        Institute institute = instituteRepository.findByInstituteId(dto.getInstituteId());
        Courses course = new Courses(dto.getCourseName(),dto.getCourseDescription(),
                dto.getCourseDuration(),dto.getCourseTiming(),dto.getCourseStudentCount(),
                dto.getCourseAcademicYear(),dto.getCourseRequiredPercentage(),institute);
        coursesRepository.save(course);
        return "Saved Course";
    }

    @Override
    public List<GetAllCoursesDto> getAllCourses(Long instituteId) {

        List<GetAllCoursesDto> courseList=coursesRepository.getAllCourses(instituteId);
       /* for(Courses i : courseList){
            System.out.println(i.getCourseName());
        }*/
        return courseList;
    }

    @Override
    public List<GetAllCoursesAdminDto> getAllCourses() {
          List<GetAllCoursesDto> listCourse=coursesRepository.getAllCourses();
        ArrayList<GetAllCoursesAdminDto> adminCourseList= new ArrayList<>();
          for(GetAllCoursesDto dto:listCourse){
              Institute institute = instituteRepository.findByInstituteId(dto.getInstituteId());
              GetAllCoursesAdminDto getAllCoursesAdminDto = new GetAllCoursesAdminDto(
                      institute.getInstituteName(),dto.getCourseId(),dto.getCourseName(),
                      dto.getCourseDescription(),dto.getCourseDuration(),dto.getCourseTiming(),
                       dto.getCourseStudentCount(), dto.getCourseAcademicYear(),
                      dto.getCourseRequiredPercentage());
              adminCourseList.add(getAllCoursesAdminDto);

          }
    return adminCourseList;
    }

    @Override
    public ViewCourseDto getCourseById(long id) {

         Courses course=coursesRepository.findByCourseId(id);
         ViewCourseDto courseDto = new ViewCourseDto(
                 course.getCourseId(),course.getCourseName(),course.getCourseDescription(),
                 course.getCourseDuration(),course.getCourseTiming(),course.getCourseStudentCount(),
                 course.getCourseAcademicYear(),course.getCourseRequiredPercentage()
         );

         return courseDto;



    }

    @Override
    public void editCourse(long id, ViewCourseDto dto) {

        coursesRepository.editCourseById(id,dto.getCourseName(),dto.getCourseDescription(),
                dto.getCourseDuration(),dto.getCourseTiming(),dto.getCourseStudentCount(),
                dto.getCourseAcademicYear(),dto.getCourseRequiredPercentage());
    }

    @Override
    public void deleteCourse(long id) {
         coursesRepository.deleteCourseById(id);
    }


}

