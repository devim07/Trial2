package com.jenkins.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.jenkins.config.JenkinsServerConfig;

@FeignClient(name = "Jenkins-service", url = "http://localhost:8080/api/json?tree=jobs[name,buildable]", configuration = JenkinsServerConfig.class)

public interface JenkinsFeignService {
	
	@GetMapping("")
	public ResponseEntity<?> getAllJobs();	

}
