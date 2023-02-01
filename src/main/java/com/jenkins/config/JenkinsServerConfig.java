package com.jenkins.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import feign.auth.BasicAuthRequestInterceptor;

public class JenkinsServerConfig {
	
	@Value("${jenkins.username}")
	private String username;

	@Value("${jenkins.password}")
	private String password;

	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor(username, password);
	}

}
