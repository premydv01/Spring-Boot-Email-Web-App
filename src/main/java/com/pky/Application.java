package com.pky;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.pky.utils.EmailUtils;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt=SpringApplication.run(Application.class, args);
				EmailUtils emailUtils=ctxt.getBean(EmailUtils.class);
				
				String to="pprakash6672@gmail.com" ;
				String subject="<h1>This is for testing</h1>";
				String body="<b>This mail sent from Spring Boot Application</b>";
				
			//	boolean isSent=emailUtils.sendEmail(to, subject, body);
				boolean isSent=emailUtils.sendEmailNew(to, subject, body);
				
				System.out.println("Email Sent ?"+isSent);
	}

}
