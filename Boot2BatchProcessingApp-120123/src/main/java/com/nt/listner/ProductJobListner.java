package com.nt.listner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class ProductJobListner implements JobExecutionListener {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	private Long startTime;
	
	@Override
	public void beforeJob(JobExecution je) {
		startTime = System.currentTimeMillis();
		log.info(new StringBuilder().append("BATCH PROCESSING STARTED WITH STATUS : ").append(je.getStatus()).toString());
	
	}

	@Override
	public void afterJob(JobExecution je) {
		log.info(new StringBuilder().append("BATCH PROCESSING FINISHED ").append(je.getStatus()).toString());
		Long endTime = System.currentTimeMillis();
		log.info(new StringBuilder().append("TIME TAKEN TO FINISH TASK ").append(endTime-startTime).toString());
	}

}
