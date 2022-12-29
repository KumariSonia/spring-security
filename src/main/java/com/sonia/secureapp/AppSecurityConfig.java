package com.sonia.secureapp;
//import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;

	}

//	@Bean
//	protected UserDetailsService userDetailService() {
//		Collection<UserDetails> users = new ArrayList<>();
//
//		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
//				.build();
//
//		users.add(user);
//
//		return new InMemoryUserDetailsManager(users);
//	}

}
