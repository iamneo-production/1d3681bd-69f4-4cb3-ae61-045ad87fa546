package com.examly.springapp.service;


import com.examly.springapp.model.Role;
import com.examly.springapp.model.User;

import com.examly.springapp.repository.UserRepository;

import com.examly.springapp.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder encoder;


    public User save(UserRegistrationDto userRegistrationDto) {
        User admin =new User(userRegistrationDto.getEmail(),userRegistrationDto.getUserName(),
                userRegistrationDto.getUserMobileNumber(), encoder.encode(userRegistrationDto.getUserPassword())
                , Arrays.asList(new Role("ROLE_admin")));
        try {return userRepository.save(admin);}
        catch(Exception e){
            System.out.println("Exception thrown during Saving Admin : "+e);
            return null;
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User admin = userRepository.findByEmail(username);

        if(admin == null) throw new UsernameNotFoundException("Invalid username and password");
            for(Role r:admin.getRoles())System.out.println(r.getName());

        return new org.springframework.security.core.userdetails.User(admin.getUserEmail(),admin.getUserPassword(),authorities(admin.getRoles()));

    }

    Collection<? extends GrantedAuthority> authorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
