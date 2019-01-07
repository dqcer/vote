package com.dqcer.vote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoteApplication.class, args);
	}

	private	 	String		code	;
	private		String		user_name	;
	private		String		user_password	;
	private		String		salt	;
	private		String		create_time	;
	private		String		update_time	;
	private		String		status	;



}

