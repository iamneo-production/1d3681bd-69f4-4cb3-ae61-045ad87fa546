package com.examly.springapp.service;

import com.examly.springapp.model.Admin;
import com.examly.springapp.model.Role;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.AdminRepository;
import com.examly.springapp.web.dto.AdminRegistrationDto;
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
    AdminRepository adminRepository;
    @Autowired
    BCryptPasswordEncoder encoder;


    public Admin save(AdminRegistrationDto adminRegistrationDto) {
        Admin admin =new Admin(adminRegistrationDto.getEmail(),adminRegistrationDto.getName(),
                encoder.encode(adminRegistrationDto.getPassword())
                , Arrays.asList(new Role("ROLE_admin")));
        try {return adminRepository.save(admin);}
        catch(Exception e){
            System.out.println("Exception thrown during Saving Admin : "+e);
            return null;
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Admin admin = adminRepository.findByEmail(username);

        if(admin == null) throw new UsernameNotFoundException("Invalid username and password");
            for(Role r:admin.getAdminroles())System.out.println(r.getName());

        return new org.springframework.security.core.userdetails.User(admin.getEmail(),admin.getAdminPassword(),authorities(admin.getAdminroles()));

    }

    Collection<? extends GrantedAuthority> authorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
