package com.locadora.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ConfigureSecurity extends WebSecurityConfigurerAdapter{
	@Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("evah")
		.password("123")
		.roles("ADMIN")
		.and()	
		.withUser("gisely")
		.password("123")
	.roles("ADMIN")
		.and().withUser("dayane")
		.password("123")		
		
		.roles("USER");
			
	}
	
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()		
	
		.antMatchers("/**").permitAll()
		.antMatchers("/salvar").hasAnyRole("ADMIN", "USER")
		.antMatchers("/delete/id").hasRole("ADMIN")
		.antMatchers("/editar/id").hasRole("ADMIN")
		
		.and()
		.formLogin();

	}
}
