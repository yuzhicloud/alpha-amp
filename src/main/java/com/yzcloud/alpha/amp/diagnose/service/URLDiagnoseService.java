package com.yzcloud.alpha.amp.diagnose.service;

import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseJob;
import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseProtocolEnum;
import com.yzcloud.alpha.amp.nm.domain.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class URLDiagnoseService implements DiagnoseJobService {
	
	private final Logger log = LoggerFactory.getLogger(URLDiagnoseService.class);
	
	@Override
	public List<DiagnoseJob> diagnose(List<Node> nodeList) {
		List<DiagnoseJob> taskList = new ArrayList<>();
		
		for(Node node : nodeList){
			DiagnoseJob job = new DiagnoseJob();
			job.setProtocol(DiagnoseProtocolEnum.URL.toString());
			log.debug("Start NodeRepository Diagnose:" + node.toString());
			long startTime = System.currentTimeMillis();
			job.setResult(urlChecking(node.getIpAddr()));
			long endTime = System.currentTimeMillis();
			taskList.add(job);
		}
		log.debug("End NodeRepository Diagnose" );
		return taskList;
	}
	
	public String urlChecking(String ipAddr){
		String result = "";
		int code = 200;
		String url = "http://" + ipAddr + "/names.nsf";
		try {
			URL siteURL = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(3000);
			connection.connect();
			
			code = connection.getResponseCode();
			if (code == 200) {
				result = "-> Green <-\t" + "Code: " + code;
				;
			} else {
				result = "-> Yellow <-\t" + "Code: " + code;
			}
		} catch (Exception e) {
			result = "-> Red <-\t" + "Wrong domain - Exception: " + e.getMessage();
			
		}
		return result;
	}
}
