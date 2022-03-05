package com.examly.springapp.repository;

import com.examly.springapp.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {

    Admin findByEmail(String email);
}
