package com.occoa.security.config;

import com.occoa.security.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
    	httpSecurity
    		.csrf().disable()
    		.authorizeRequests()
    		.antMatchers("/**")
    		.permitAll();
    }

	@Bean
	public AuthInterceptor authInterceptor() {
		return new AuthInterceptor();
	}
}
