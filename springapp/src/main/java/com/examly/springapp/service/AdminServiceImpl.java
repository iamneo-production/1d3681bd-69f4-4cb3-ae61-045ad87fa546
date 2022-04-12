package com.examly.springapp.service;


import com.examly.springapp.model.Role;
import com.examly.springapp.model.User;

import com.examly.springapp.repository.UserRepository;

import com.examly.springapp.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import com.examly.springapp.constants.Constants;
import com.examly.springapp.exception.ResourceNotFound;
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserRepository userRepository;



    public User save(UserRegistrationDto userRegistrationDto) {
        User admin =new User(userRegistrationDto.getEmail(),userRegistrationDto.getUserName(),
                userRegistrationDto.getUserMobileNumber(), userRegistrationDto.getUserPassword()
                , Constants.ROLE_ADMIN);
        if(userRegistrationDto.getEmail().isEmpty()||userRegistrationDto.getUserName().isEmpty()||
                userRegistrationDto.getUserMobileNumber().isEmpty()||
                userRegistrationDto.getUserPassword().isEmpty()) {
        	throw new ResourceNotFound(Constants.SIGNUP_FIELD_EMPTY);
        }
        try {return userRepository.save(admin);}
        catch(Exception e){
            System.out.println(Constants.SAVE_EXCEPTION+e);
            return null;
        }
    }




}
