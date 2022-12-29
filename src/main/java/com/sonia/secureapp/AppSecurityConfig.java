package com.sonia.secureapp;
//import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Bean
   protected UserDetailsService userDetailService() {
    	Collection<UserDetails> users = new ArrayList<>();


UserDetails user = User.withDefaultPasswordEncoder()
.username("user")
.password("password")
.roles("USER")
.build();

users.add(user);

        return new InMemoryUserDetailsManager(users);
    }
	

}
