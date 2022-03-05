package com.examly.springapp.auth;

import com.examly.springapp.service.AdminService;
import com.examly.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Configuration
    @Order(1)
    public static class AdminConfigAdapter extends WebSecurityConfigurerAdapter{
        public AdminConfigAdapter(){
            super();
        }
        @Autowired
        private AdminService adminService;

        @Bean

        public DaoAuthenticationProvider daoAuthenticationProviderAdmin(){
            DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
            auth.setUserDetailsService(adminService);
            auth.setPasswordEncoder(encoderAdmin());
            return auth;
        }
        @Bean
        @Primary
        public BCryptPasswordEncoder encoderAdmin(){
            return new  BCryptPasswordEncoder();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder amb) throws Exception {
            amb.authenticationProvider(daoAuthenticationProviderAdmin());
        }
        @Override
        protected void configure(HttpSecurity http) throws Exception{

            http.csrf().disable()
                    .antMatcher("/admin/**")
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST,"/admin/signup","admin/login").permitAll()
                    .antMatchers("/admin/**").hasRole("admin")
                    .anyRequest()
                    .authenticated()

                    .and()
                    .formLogin()
                    .loginProcessingUrl("/admin/login")

                    .defaultSuccessUrl("/admin/dashboard")

                    .and()
                    .logout()
                    .logoutUrl("/admin/logout")


                    ;
        }



    }

    @Configuration
    @Order(2)
    public static class UserConfigAdapter extends WebSecurityConfigurerAdapter{
        public UserConfigAdapter(){
            super();
        }
        @Autowired
        private UserService userService;

        @Bean
        public DaoAuthenticationProvider daoAuthenticationProvider(){
            DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
            auth.setUserDetailsService(userService);
            auth.setPasswordEncoder(encoder());
            return auth;
        }
        @Bean
        public BCryptPasswordEncoder encoder(){
            return new  BCryptPasswordEncoder();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder amb) throws Exception {
            amb.authenticationProvider(daoAuthenticationProvider());
        }
        @Override
        protected void configure(HttpSecurity http) throws Exception{

            http.csrf().disable()
                    .antMatcher("/user/**")
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST,"/user/signup","/user/login").permitAll()
                    .antMatchers("/user/**").hasRole("student").anyRequest().authenticated()

                    .and()
                    .formLogin()
                    .loginProcessingUrl("/user/login")

                    .defaultSuccessUrl("/user/dashboard")

                    .and()
                    .logout()
                    .logoutUrl("/user/logout")

                    ;
        }



    }
}
