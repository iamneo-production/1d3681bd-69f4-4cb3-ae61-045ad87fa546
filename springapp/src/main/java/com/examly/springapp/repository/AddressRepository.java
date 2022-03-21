package com.examly.springapp.repository;

import com.examly.springapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AddressRepository extends JpaRepository<Address,Long> {

    @Query(value ="select * from address where address.admission_id=?1",nativeQuery = true)
    Address findByAdmissionId(long id);

    @Modifying
    @Transactional
    @Query(value = "update address set house_number=?1, street_number=?2, area_name=?3, state=?4, pin_code=?5, nationality=?6 where admission_id=?7",nativeQuery = true)
    void editAddress(String houseNumber,String streetNumber,String areaName,String state,String pinCode,String nationality,long id);


}