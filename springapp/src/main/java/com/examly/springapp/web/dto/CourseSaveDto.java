package com.examly.springapp.web.dto;
import com.examly.springapp.constants.Constants;
import org.springframework.core.ReactiveAdapterRegistry;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class CourseSaveDto {
 @NotNull
    private Long instituteId;
    @NotEmpty
    @Pattern(regexp = Constants.COURSE_NAME_REGEX_VALIDATION)
    private String courseName;
    @NotEmpty
    private String courseDescription;
    @NotEmpty
    @Pattern(regexp = Constants.COURSE_DURATION_REGEX_VALIDATION)
    private String courseDuration;
    @NotEmpty
    @Pattern(regexp = Constants.COURSE_TIMING_REGEX_VALIDATION)
    private String courseTiming;
    @NotEmpty
    @Pattern(regexp = Constants.COURSE_STUDENT_COUNT_REGEX_VALIDATION)
    private String courseStudentCount;
    @NotEmpty
    @Pattern(regexp = Constants.COURSE_ACADEMIC_YEAR_REGEX_VALIDATION)
    private String courseAcademicYear;
    @NotEmpty
    @Pattern(regexp = Constants.COURSE_REQUIRED_PERCENTAGE_REGEX_VALIDATION)
    private String courseRequiredPercentage;

    public CourseSaveDto() {
    }

    public CourseSaveDto(Long instituteId, String courseName, String courseDescription, String courseDuration, String courseTiming, String courseStudentCount, String courseAcademicYear, String courseRequiredPercentage) {
        this.instituteId = instituteId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseDuration = courseDuration;
        this.courseTiming = courseTiming;
        this.courseStudentCount = courseStudentCount;
        this.courseAcademicYear = courseAcademicYear;
        this.courseRequiredPercentage = courseRequiredPercentage;
    }

    public Long getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(Long instituteId) {
        this.instituteId = instituteId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseTiming() {
        return courseTiming;
    }

    public void setCourseTiming(String courseTiming) {
        this.courseTiming = courseTiming;
    }

    public String getCourseStudentCount() {
        return courseStudentCount;
    }

    public void setCourseStudentCount(String courseStudentCount) {
        this.courseStudentCount = courseStudentCount;
    }

    public String getCourseAcademicYear() {
        return courseAcademicYear;
    }

    public void setCourseAcademicYear(String courseAcademicYear) {
        this.courseAcademicYear = courseAcademicYear;
    }

    public String getCourseRequiredPercentage() {
        return courseRequiredPercentage;
    }

    public void setCourseRequiredPercentage(String courseRequiredPercentage) {
        this.courseRequiredPercentage = courseRequiredPercentage;
    }
}
