package com.examly.springapp.repository;

import com.examly.springapp.model.Courses;
import com.examly.springapp.web.dto.GetAllCoursesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CoursesRepository extends JpaRepository<Courses,Long> {

   /* @Query(value = "select course_id as courseId, course_academic_year as courseAcademicYear,course_description as courseDescription,course_duration as courseDuration, course_name as courseName, course_required_percentage as courseRequiredPercentage, course_student_count as courseStudentCount, course_timing as courseTiming, institute_id as instituteId from courses where course_id= :id ",nativeQuery = true)
    GetAllCoursesDto findByCourseId(@Param("id") long id);*/

    Courses findByCourseId(@Param("id") long id);

    @Query(value = "select course_id as courseId, course_academic_year as courseAcademicYear,course_description as courseDescription,course_duration as courseDuration, course_name as courseName, course_required_percentage as courseRequiredPercentage, course_student_count as courseStudentCount, course_timing as courseTiming, institute_id as instituteId from courses where courses.institute_id= :instituteId ",nativeQuery = true)
    List<GetAllCoursesDto> getAllCourses(@Param("instituteId") long instituteId);

    @Query(value = "select course_id as courseId, course_academic_year as courseAcademicYear,course_description as courseDescription,course_duration as courseDuration, course_name as courseName, course_required_percentage as courseRequiredPercentage, course_student_count as courseStudentCount, course_timing as courseTiming, institute_id as instituteId from courses",nativeQuery = true)
    List<GetAllCoursesDto> getAllCourses();

    @Modifying
    @Transactional
    @Query(value = "update courses set course_name= ?2, course_description= ?3, course_duration= ?4, course_timing= ?5, course_student_count= ?6, course_academic_year= ?7, course_required_percentage= ?8 where course_id= ?1 ",nativeQuery = true)
    void editCourseById(long id,String courseName, String courseDescription, String courseDuration, String courseTiming, String courseStudentCount, String courseAcademicYear, String courseRequiredPercentage);

    @Modifying
    @Transactional
    @Query(value = "delete from courses where course_id = ?1",nativeQuery = true)
    void deleteCourseById(long id);
}
