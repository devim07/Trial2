package com.jenkins.service.impl;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenkins.entities.JenkinsResponse;
import com.jenkins.feign.service.JenkinsFeignService;

import lombok.extern.slf4j.Slf4j;

@Service@Slf4j
public class JenkinsService implements com.jenkins.service.JenkinsService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private JenkinsFeignService jenkinsFeignService;
	
	@Override
	public JenkinsResponse getAlljobs() {
		JenkinsResponse jenkinsResponse = modelMapper.map(jenkinsFeignService.getAllJobs().getBody(),
				JenkinsResponse.class);
		log.info("JenkinsResponse :: {}", jenkinsResponse);

		jenkinsResponse.setJobs(jenkinsResponse.getJobs().parallelStream().map(job -> {

			String status = switch (job.getColor()) {
			case "blue" -> "Success";
			case "red" -> "Failed";
			case "notbuilt" -> "Not Built";
			default -> job.getColor();
			};

			job.setStatus(status);

			return job;
		}).collect(Collectors.toList()));
		

		log.info("JenkinsResponse pot mapping:: {}", jenkinsResponse);
		return jenkinsResponse;
	}

}
