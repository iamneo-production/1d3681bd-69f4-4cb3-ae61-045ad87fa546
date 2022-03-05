package com.examly.springapp.service;

import com.examly.springapp.model.Courses;
import com.examly.springapp.model.Institute;
import com.examly.springapp.model.Student;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.CoursesRepository;
import com.examly.springapp.repository.InstituteRepository;
import com.examly.springapp.repository.StudentRepository;
import com.examly.springapp.repository.UserRepository;
import com.examly.springapp.web.dto.GetAllAppliedCoursesDto;
import com.examly.springapp.web.dto.GetAllCoursesDto;
import com.examly.springapp.web.dto.StudentSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CoursesRepository coursesRepository;
    @Autowired
    InstituteRepository instituteRepository;


    @Override
    public void saveStudent(StudentSaveDto dto, Authentication auth) {

        User user = userRepository.findByEmail(auth.getName());
        Courses course = coursesRepository.findByCourseId(dto.getCourseId());

       /* Courses newCourse = new Courses(course.getCourseName(),course.getCourseDescription(),
                course.getCourseDuration(),course.getCourseTiming(),course.getCourseStudentCount(),
                course.getCourseAcademicYear(),course.getCourseRequiredPercentage(),instituteRepository.findByInstituteId(course.getInstituteId()));
*/
        Student student = new Student(dto.getFirstName(),dto.getLastName(),dto.getEmail(),
                dto.getMobile(),dto.getGender(),dto.getFatherName(),dto.getMotherName(),
                dto.getAge(),dto.getHscName(),dto.getHscMarks(),dto.getEligibility(),
                false,false,user,course);
        studentRepository.save(student);



    }

    @Override
    public List<GetAllAppliedCoursesDto> getAllAppliedCourses(Authentication auth) {
        User user=userRepository.findByEmail(auth.getName());

        List<Student> studentList= studentRepository.findByUserId(user.getUserId());
        ArrayList<GetAllAppliedCoursesDto> list = new ArrayList<>();
        for(Student student:studentList){

            Courses course = student.getCourse();
            Institute institute= course.getInstitute();
            GetAllAppliedCoursesDto getAllAppliedCoursesDto = new GetAllAppliedCoursesDto(
                    student.getStudentId(),student.isAccepted(),student.isDenied(),
                    course.getCourseId(),course.getCourseName(),course.getCourseDescription(),
                    course.getCourseDuration(),course.getCourseTiming(),course.getCourseStudentCount(),
                    course.getCourseAcademicYear(),course.getCourseRequiredPercentage(),
                    institute.getInstituteName(),institute.getInstituteDescription(),
                    institute.getInstituteCity(),institute.getInstituteState(),institute.getInstituteEmail(),
                    institute.getInstituteMobile(),institute.getNirfRank()
            );
            list.add(getAllAppliedCoursesDto);

        }

        return list;
    }
}
