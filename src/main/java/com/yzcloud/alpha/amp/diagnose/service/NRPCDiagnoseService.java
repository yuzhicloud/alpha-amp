package com.yzcloud.alpha.amp.diagnose.service;

import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseTask;
import com.yzcloud.alpha.amp.nm.domain.Node;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NRPCDiagnoseService implements DiagnoseService{
	
	@Override
	public List<DiagnoseTask> diagnose(List<Node> nodeList) {
		return null;
	}
}
