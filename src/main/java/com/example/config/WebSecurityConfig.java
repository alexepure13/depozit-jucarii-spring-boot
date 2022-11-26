package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/logout").hasAnyRole("ADMIN","USER")
				.antMatchers("/").hasAnyRole("ADMIN","USER")
				.antMatchers("/index").hasAnyRole("ADMIN","USER")
				.antMatchers("/toys").hasAnyRole("ADMIN")
				.antMatchers("/categories").hasAnyRole("ADMIN")
				.antMatchers("/categories-view").hasAnyRole("ADMIN","USER")
				.antMatchers("/toys-view").hasAnyRole("ADMIN","USER")
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
		http.headers().frameOptions().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/static/**", "/css/**", "/js/**","/img/**","/fonts/**");
	}

	@Bean
	public UserDetailsService users() {
		// The builder will ensure the passwords are encoded before saving in memory
		User.UserBuilder users = User.withDefaultPasswordEncoder();
		UserDetails user = users
				.username("user")
				.password("pass")
				.roles("USER")
				.build();
		UserDetails admin = users
				.username("admin")
				.password("pass")
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
}
