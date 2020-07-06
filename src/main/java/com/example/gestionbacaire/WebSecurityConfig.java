package com.example.gestionbacaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.gestionbacaire.securite.security.jwt.AuthEntryPointJwt;
import com.example.gestionbacaire.securite.security.jwt.AuthTokenFilter;
import com.example.gestionbacaire.service.impl.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
      
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.authorizeRequests().antMatchers("/api/auth/signin").permitAll()
			.antMatchers("/api/test/**").permitAll()
			.antMatchers("/simpleemail").permitAll()			
			.antMatchers("/gestionbancaire/operation/**").permitAll()
			.antMatchers("/gestionbancaire/client/verfierviaGamil").permitAll()
			//.antMatchers("/gestionbancaire/**").permitAll()
			.antMatchers("/gestionbancaire/operation/c/**").permitAll()
			.antMatchers("/gestionbancaire/operation/rib/**").permitAll()
			//.antMatchers("/gestionbancaire/client/**").permitAll()
			.antMatchers("/gestionbancaire/employe/**").permitAll()
			.antMatchers("/gestionbancaire/facture/**").permitAll()
			.antMatchers("/gestionbancaire/compte/**").permitAll()
			.antMatchers("/gestionbancaire/compte/Username").permitAll()
			.antMatchers("/api/auth/signup").permitAll()
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.anyRequest().authenticated().and()
		    .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		     
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
