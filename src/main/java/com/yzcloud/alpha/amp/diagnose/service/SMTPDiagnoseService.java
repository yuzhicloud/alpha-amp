package com.yzcloud.alpha.amp.diagnose.service;

import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseTask;
import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseTaskTypeEnum;
import com.yzcloud.alpha.amp.nm.domain.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class SMTPDiagnoseService implements  DiagnoseService{
	
	private final Logger log = LoggerFactory.getLogger(SMTPDiagnoseService.class);
	
	@Override
	public List<DiagnoseTask> diagnose(List<Node> nodeList) {
		List<DiagnoseTask> taskList = new ArrayList<>();
		try {
			for (Node node : nodeList) {
				DiagnoseTask task = new DiagnoseTask();
				task.setTaskType(DiagnoseTaskTypeEnum.SMTP);
				log.debug("Start NodeRepository Diagnose:" + node.toString());
				long startTime = System.currentTimeMillis();
				task.setExpectResult(sendMail(node.getIpAddr()));
				long endTime = System.currentTimeMillis();
				taskList.add(task);
			}
			log.debug("End NodeRepository Diagnose");
		}catch (Exception ex){
			ex.printStackTrace();
		}
		return taskList;
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
