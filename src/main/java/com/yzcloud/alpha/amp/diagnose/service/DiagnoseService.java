package com.yzcloud.alpha.amp.diagnose.service;


import com.yzcloud.alpha.amp.diagnose.domain.DiagnoseTask;
import com.yzcloud.alpha.amp.nm.domain.Node;

import java.util.List;

public interface DiagnoseService {
	
	List<DiagnoseTask> diagnose(List<Node> nodeList);

}
