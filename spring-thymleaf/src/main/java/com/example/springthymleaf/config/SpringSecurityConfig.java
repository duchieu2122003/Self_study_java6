//package com.example.springthymleaf.config;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfiguration {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // Cấu hình nguồn dữ liệu xác thực
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}admin").roles("ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN") // Các URL bắt đầu bằng /admin/ chỉ được truy cập bởi vai trò ADMIN
//                .antMatchers("/**").authenticated() // Tất cả các URL khác đều yêu cầu xác thực
//                .and()
//                .formLogin() // Sử dụng form login
//                .and()
//                .httpBasic(); // Sử dụng HTTP Basic Authentication
//    }
//}
//
//
