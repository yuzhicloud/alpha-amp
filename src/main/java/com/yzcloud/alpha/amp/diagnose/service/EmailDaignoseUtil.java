package com.yzcloud.alpha.amp.diagnose.service;


import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public class EmailDaignoseUtil{
	
	/**
	 * Utility method to send simple HTML email
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public static void sendEmail(Session session,
	                             String toEmail,
	                             String subject,
	                             String body)throws Exception{
		
		
		Transport transport = session.getTransport();
		try
		{
			MimeMessage msg = new MimeMessage(session);
			//set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			
			msg.setFrom(new InternetAddress("admin", "NoReply-JD"));
			
			msg.setReplyTo(InternetAddress.parse("admin", false));
			
			msg.setSubject(subject, "UTF-8");
			
			msg.setText(body, "UTF-8");
			
			msg.setSentDate(new Date());
			
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			System.out.println("Message is ready");
			
			transport.send(msg);
			
			System.out.println("EMail Sent Successfully!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			transport.close();
		}
	}
}