package com.yzcloud.alpha.amp.web.diagnose;

import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseJob;
import com.yzcloud.alpha.amp.diagnose.service.*;
import com.yzcloud.alpha.amp.nm.domain.Node;
import com.yzcloud.alpha.amp.nm.service.NodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/diagnose")
public class DiagnoseController {
	
	private final Logger log = LoggerFactory.getLogger(DiagnoseController.class);
	
	
	private final IMAPDiagnoseService imapDiagnoseService;
	private final URLDiagnoseService urlDiagnoseService;
	private final SMTPDiagnoseService smtpDiagnoseService;
	private final NRPCDiagnoseService nrpcDiagnoseService;
	private final NodeService nodeService;
	
	
	public DiagnoseController(URLDiagnoseService urlDiagnoseService,
	                          SMTPDiagnoseService smtpDiagnoseService,
	                          IMAPDiagnoseService imapDiagnoseService,
	                          NRPCDiagnoseService nrpcDiagnoseService,
	                          NodeService nodeService
	                          ){
		this.urlDiagnoseService = urlDiagnoseService;
		this.smtpDiagnoseService = smtpDiagnoseService;
		this.imapDiagnoseService = imapDiagnoseService;
		this.nrpcDiagnoseService = nrpcDiagnoseService;
		this.nodeService = nodeService;
	}
	
	@GetMapping
	public List<DiagnoseJob> getJobs(){
		
		List<DiagnoseJob> jobList;
		List<Node> nodes = this.nodeService.findAll();
		jobList = this.urlDiagnoseService.diagnose(nodes);
		jobList.addAll(this.smtpDiagnoseService.diagnose(nodes));
		log.info("Successfully get jobs:" + jobList.size());
		return jobList;
	}
}
