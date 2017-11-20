package com.micro.service.core.config;//package com.spring.boot.springboot.config;
//
//import com.spring.boot.springboot.dao.ReaderRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
///**
// * @Author zhy
// * @Date 2017/11/14 下午6:54
// */
//@Configuration
//@EnableWebSecurity
//public class SercurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private ReaderRepository readerRepository;
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.userDetailsService(new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                return (UserDetails) readerRepository.findOne(username);
//            }
//        });
//        super.configure(auth);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests().antMatchers("/").access("hasRole('READER')")
//                .antMatchers("/**").permitAll().and()
//                .formLogin().loginPage("/login").failureUrl("/login?error=true");
////        super.configure(http);
//    }
//}
