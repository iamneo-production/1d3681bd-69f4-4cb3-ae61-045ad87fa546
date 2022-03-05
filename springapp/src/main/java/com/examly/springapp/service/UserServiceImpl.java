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
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user =new User(userRegistrationDto.getUserEmail(),userRegistrationDto.getUserName(),
                userRegistrationDto.getUserMobileNumber(),passwordEncoder.encode(userRegistrationDto.getUserPassword())
                , Arrays.asList(new Role("ROLE_student")));
        try {return userRepository.save(user);}
        catch(Exception e){
            System.out.println("Exception thrown during Saving User : "+e);
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);

        if(user == null) throw new UsernameNotFoundException("Invalid username and password");


        return new org.springframework.security.core.userdetails.User(user.getUserEmail(),user.getUserPassword(),authorities(user.getRoles()));

    }

    Collection<? extends GrantedAuthority> authorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
