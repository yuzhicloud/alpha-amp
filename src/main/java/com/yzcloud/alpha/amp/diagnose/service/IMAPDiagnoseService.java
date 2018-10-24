package com.yzcloud.alpha.amp.diagnose.service;

import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseJob;
import com.yzcloud.alpha.amp.nm.domain.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IMAPDiagnoseService implements DiagnoseJobService {
	
	private final Logger log = LoggerFactory.getLogger(IMAPDiagnoseService.class);
	
	@Override
	public List<DiagnoseJob> diagnose(List<Node> nodeList) {
		return null;
	}
	
	public String sendMail(){

		return null;
	}
}
