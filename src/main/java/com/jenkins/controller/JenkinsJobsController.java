package com.jenkins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jenkins.entities.JenkinsResponse;
import com.jenkins.service.JenkinsService;

@RestController
@RequestMapping("/jenkins")
public class JenkinsJobsController {
	
	@Autowired
	private JenkinsService jenkinsService;
	
	@GetMapping("/get-all-jobs")
	public ResponseEntity<?> getAllJobs() {
		JenkinsResponse jenkinsResponse = jenkinsService.getAlljobs();
		return ResponseEntity.ok(jenkinsResponse);

	}

}
