package com.nt.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(value = "my.db")
public class MyDbConnection {
	private  String driver;
	private String url;
	private String username;
	private String pwd;
}
