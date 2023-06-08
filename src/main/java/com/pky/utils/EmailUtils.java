package com.pky.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
    
	 @Autowired
	private JavaMailSender javaMailSender;
	
	public boolean sendEmail(String to,String subject,String body) {
		
		System.out.println(javaMailSender);
		System.out.println(javaMailSender.getClass().getName());
		try {
			SimpleMailMessage msg=new SimpleMailMessage();
			msg.setTo(to);
			msg.setSubject(subject);
			msg.setText(body);
			
			javaMailSender.send(msg);
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean sendEmailNew(String to,String subject ,String body) {
		try {
		MimeMessage msg=javaMailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(msg);
		
		String[] recipient=new String[2];
		recipient[0]="pprakash6672@gmail.com";
		recipient[1]="pprabha5458@gmail.com";
		helper.setTo(recipient);
		helper.setSubject(subject);
		helper.setText(body,true);
		
		javaMailSender.send(msg);
		return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
