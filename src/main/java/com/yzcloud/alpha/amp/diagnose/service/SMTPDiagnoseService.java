package com.yzcloud.alpha.amp.diagnose.service;

import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseJob;
import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseProtocolEnum;
import com.yzcloud.alpha.amp.nm.domain.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.Session;
import java.util.ArrayList;
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
		String smtpHostServer = "47.106.227.209";
		String emailID = "admin";
		
		Properties props = System.getProperties();
		props.put(ip, smtpHostServer);
		Session session = Session.getInstance(props, null);
		
		try {
			EmailDaignoseUtil.sendEmail(session, emailID, "SimpleEmail Testing Subject", "SimpleEmail Testing Body");
			log.debug("SMTP diagnose successfully");
			result = "Successful";
		}catch(Exception ex){
			result = ex.toString();
			log.debug(result);
		}
		return result;
	}
}
