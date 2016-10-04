package util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String username = "pradipto.logicocean@gmail.com";

		final String password = "pradipto@_12345";

		Properties props = new Properties();
		props.put("mail.smtp.user","Pradipto"); 
		props.put("mail.smtp.host", "smtp.gmail.com"); 
		props.put("mail.smtp.port", "25"); 
		props.put("mail.debug", "true"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.starttls.enable","true"); 
		props.put("mail.smtp.EnableSSL.enable","true");

		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
		props.setProperty("mail.smtp.socketFactory.fallback", "false");   
		props.setProperty("mail.smtp.port", "465");   
		props.setProperty("mail.smtp.socketFactory.port", "465"); 

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress("pradiptoroy16@gmail.com"));
			
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("avinash.locean@gmail.com"));
			
			message.setSubject("CHECKING MAIL");
			message.setText("MAIL THOROUGH JAVA PROGRAME....   :)");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			System.out.println("Exception found ..."+e);
			throw new RuntimeException(e);
		}
		
	}

}
