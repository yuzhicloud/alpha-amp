package com.yzcloud.alpha.amp.diagnose.service;

import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseTask;
import com.yzcloud.alpha.amp.nm.domain.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.Session;
import java.util.List;
import java.util.Properties;


@Service
public class IMAPDiagnoseService implements DiagnoseService{
	
	private final Logger log = LoggerFactory.getLogger(IMAPDiagnoseService.class);
	
	@Override
	public List<DiagnoseTask> diagnose(List<Node> nodeList) {
		return null;
	}
	
	public String sendMail(){

		return null;
	}
}
