package com.yzcloud.alpha.amp.diagnose.service;


import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseJob;
import com.yzcloud.alpha.amp.nm.domain.Node;

import java.util.List;

public interface DiagnoseJobService {
	
	List<DiagnoseJob> diagnose(List<Node> nodeList);

}
