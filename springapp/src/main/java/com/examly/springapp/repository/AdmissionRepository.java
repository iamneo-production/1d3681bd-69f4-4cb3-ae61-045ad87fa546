package com.examly.springapp.repository;

import com.examly.springapp.model.Admission;
import com.examly.springapp.web.dto.GetAllAdmissionRequests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdmissionRepository extends JpaRepository<Admission,Long> {

    @Query(value = "select * from admission where admission.user_id= :userId",nativeQuery = true)
    List<Admission> findByUserId(@Param("userId") long userId);

    @Query(value="select admission_id as admissionId, accepted as accepted, age as age, denied as denied , eligibility as eligibility, email as email, father_name as fatherName, first_name as firstName, gender as gender, hsc_marks as hscMarks, hsc_name as hscName, last_name as lastName, mobile as mobile, mother_name as motherName, course_id as courseId, user_id as userId from admission where admission.accepted=false and admission.denied=false",nativeQuery = true)
    List<GetAllAdmissionRequests> getAllAdmissionRequests();

    @Modifying
    @Transactional
    @Query(value = "update admission set admission.accepted=true where admission.admission_id=?1",nativeQuery = true)
    void acceptAdmission(long id);

    @Modifying
    @Transactional
    @Query(value = "update admission set admission.denied=true where admission.admission_id=?1",nativeQuery = true)
    void denyAdmission(long id);

    @Query(value="select admission_id as admissionId, accepted as accepted, age as age, denied as denied , eligibility as eligibility, email as email, father_name as fatherName, first_name as firstName, gender as gender, hsc_marks as hscMarks, hsc_name as hscName, last_name as lastName, mobile as mobile, mother_name as motherName, course_id as courseId, user_id as userId from admission where admission.accepted=true",nativeQuery = true)
    List<GetAllAdmissionRequests> getAllAcceptedAdmission();

    @Query(value="select admission_id as admissionId, accepted as accepted, age as age, denied as denied , eligibility as eligibility, email as email, father_name as fatherName, first_name as firstName, gender as gender, hsc_marks as hscMarks, hsc_name as hscName, last_name as lastName, mobile as mobile, mother_name as motherName, course_id as courseId, user_id as userId from admission where admission.denied=true",nativeQuery = true)
    List<GetAllAdmissionRequests> getAllDeniedAdmission();

    @Query(value="select admission_id as admissionId, accepted as accepted, age as age, denied as denied , eligibility as eligibility, email as email, father_name as fatherName, first_name as firstName, gender as gender, hsc_marks as hscMarks, hsc_name as hscName, last_name as lastName, mobile as mobile, mother_name as motherName, course_id as courseId, user_id as userId from admission where admission.admission_id=?1",nativeQuery = true)
    GetAllAdmissionRequests getAdmissionById(long id);

    @Modifying
    @Transactional
    @Query(value = "update admission set first_name=?1, last_name=?2, email=?3, mobile=?4, gender=?5, father_name=?6, mother_name=?7, age=?8, hsc_name=?9, hsc_marks=?10, eligibility=?11 where  admission_id=?12",nativeQuery = true)
    void editAdmission(String firstName,String lastName,String email,String mobile,String gender,String fatherName,String motherName,String age,String hscName,long hscMarks,String eligibility,long id);

    @Modifying
    @Transactional
    @Query(value = "delete from admission where admission_id=?1",nativeQuery = true)
    void deleteAdmission(long id);
}