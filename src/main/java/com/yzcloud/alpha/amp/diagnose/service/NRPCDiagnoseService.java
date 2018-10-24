package com.yzcloud.alpha.amp.diagnose.service;

import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseJob;
import com.yzcloud.alpha.amp.nm.domain.Node;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NRPCDiagnoseService implements DiagnoseJobService {
	
	@Override
	public List<DiagnoseJob> diagnose(List<Node> nodeList) {
		return null;
	}
}
