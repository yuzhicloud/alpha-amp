package com.yzcloud.alpha.amp.diagnose.service;

import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseJob;
import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseProtocolEnum;
import com.yzcloud.alpha.amp.nm.domain.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class SMTPDiagnoseService implements DiagnoseJobService {
	
	private final Logger log = LoggerFactory.getLogger(SMTPDiagnoseService.class);
	
	@Override
	public List<DiagnoseJob> diagnose(List<Node> nodeList) {
		List<DiagnoseJob> jobList = new ArrayList<>();
		try {
			for (Node node : nodeList) {
				DiagnoseJob job = new DiagnoseJob();
				job.setNodeIpAddr(node.getIpAddr());
				job.setProtocol(DiagnoseProtocolEnum.SMTP.toString());
				log.debug("Start NodeRepository Diagnose:" + node.toString());
				long startTime = System.currentTimeMillis();
				job.setResult(sendMail(node.getIpAddr()));
				long endTime = System.currentTimeMillis();
				jobList.add(job);
			}
			log.debug("End NodeRepository Diagnose");
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return jobList;
	}
	
	public String sendMail(String ip)throws Exception{
		String result = "";
		log.debug("SMTP diagnose start");
		String smtpHostServer = ip;
		log.info("=====>SMTP Ipaddress = " + ip);
		String emailID = "admin";
		
		Properties props = System.getProperties();
		//props.put(ip, smtpHostServer);
		props.put("mail.smtp.host", ip);
		props.put("mail.smtp.port", 25);
		
		Session session = Session.getInstance(props, null);
		try {
			Transport transport = session.getTransport();
			try
			{
				MimeMessage msg = new MimeMessage(session);
				String mailTo = "admin";
				msg.setFrom(new InternetAddress("admin", "admin","UTF-8"));
				msg.setReplyTo(InternetAddress.parse("admin", false));
				msg.setSubject("subject-test", "UTF-8");
				msg.setText("body-test", "UTF-8");
				msg.setSentDate(new Date());
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailTo, false));
				log.info("SMTP Message is ready");
				transport.send(msg);
				log.info("SMTP EMail Sent Successfully!!");
			}
			catch (Exception e) {
				e.printStackTrace();
			}finally {
				transport.close();
			}
			log.debug("SMTP diagnose successfully");
			result = "Successful";
		}catch(Exception ex){
			result = ex.toString();
			log.debug(result);
		}
		return result;
	}
}
