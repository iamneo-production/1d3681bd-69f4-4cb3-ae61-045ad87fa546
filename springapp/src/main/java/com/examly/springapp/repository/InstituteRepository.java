package com.examly.springapp.repository;

import com.examly.springapp.model.Institute;
import com.examly.springapp.web.dto.InstituteSaveDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InstituteRepository extends JpaRepository<Institute,Long> {

    Institute findByInstituteId(long id);

    @Query(value = "select * from institute",nativeQuery = true)
    List<Institute> getAllInstitute();

    @Modifying
    @Transactional
    @Query(value = "update institute set institute_name= ?2, institute_description= ?3, institute_city= ?4, institute_state= ?5, institute_email= ?6,institute_mobile= ?7,nirf_rank= ?8   where institute_id= ?1",nativeQuery = true)
    void editInstituteById(long instituteId,String instituteName, String instituteDescription, String instituteCity, String instituteState, String instituteEmail, String instituteMobile, int nirfRank);

    @Modifying
    @Transactional
    @Query(value = "delete from institute where institute_id= :id",nativeQuery = true)
    void deleteInstituteById(@Param("id") long id);
}
