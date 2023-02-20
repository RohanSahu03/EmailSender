package com.device.EmailApi;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.net.httpserver.HttpExchange;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
   
    	String message="hii there";
    	String to="rohansahu9893@gmail.com";
    	String subject="hiiii";
    	String from="sahurohankumar47@gmail.com";
    	
    	sendEmail(message,to,subject,from);
}

	private static void sendEmail(String message, String to, String subject, String from) {
		// TODO Auto-generated method stub
		
		String host="smtp.gmail.com";
		Properties properties = System.getProperties();
		System.out.println("properties"+ properties);
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		
		
		Session session=Session.getInstance(properties, new Authenticator() {

		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("sahurohankumar47@gmail.com","Rohan@1to5");
		}
			
		});
		
		session.setDebug(true);
		MimeMessage mimeMessage = new MimeMessage(session);
		try {
			mimeMessage.setFrom(from);
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(message);
			
			Transport.send(mimeMessage);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
