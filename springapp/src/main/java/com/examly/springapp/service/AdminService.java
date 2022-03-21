package com.examly.springapp.service;


import com.examly.springapp.model.User;

import com.examly.springapp.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface AdminService extends UserDetailsService {

    User save(UserRegistrationDto userRegistrationDto);
}
