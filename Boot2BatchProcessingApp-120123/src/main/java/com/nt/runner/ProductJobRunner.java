package com.nt.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductJobRunner implements CommandLineRunner {

	@Autowired
	private Job jobA;
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Override
	public void run(String... args) throws Exception {
		JobParameters jp = 
				new JobParametersBuilder()
				.addLong("time", System.currentTimeMillis())
				.toJobParameters();
		jobLauncher.run(jobA, jp);
	}

}
