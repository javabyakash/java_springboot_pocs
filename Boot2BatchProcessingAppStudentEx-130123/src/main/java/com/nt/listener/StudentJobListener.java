package com.nt.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class StudentJobListener implements JobExecutionListener {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	private Long startTime;
	
	@Override
	public void beforeJob(JobExecution je) {
		log.info("BATCH PROCESSING START WITH STATUS : "+je.getStatus());
		startTime = System.currentTimeMillis();
	}

	@Override
	public void afterJob(JobExecution je) {
		log.info("BATCH PROCESSING FINISHED WITH STATUS : "+je.getStatus());
		Long endTime = System.currentTimeMillis();
		log.info("TOTAL TIME TAKEN TO FINSH THE TASK : "+(endTime-startTime));
	}
}
