package com.jenkins.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JenkinsJob {
	
	@JsonProperty("job_name")
	private String name;

	@JsonIgnore
	private String color;

	@JsonProperty("job_status")
	private String status;

}
