package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.MyDbConnection;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Autowired
	private MyDbConnection con;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(con);
	}

}
