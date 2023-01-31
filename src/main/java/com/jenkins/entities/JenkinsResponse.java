package com.jenkins.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JenkinsResponse {

	private List<JenkinsJob> jobs;
	
}
