package com.yzcloud.alpha.amp.nm.service;

import com.yzcloud.alpha.amp.nm.domain.Node;
import com.yzcloud.alpha.amp.nm.repository.NodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NodeService {
	
	private final Logger log = LoggerFactory.getLogger(NodeService.class);
	
	private final NodeRepository nodeRepository;
	
	public NodeService(NodeRepository nodeRepository){
		this.nodeRepository = nodeRepository;
	}
	
	public Optional<Node> getNodeById(Long id){
		return nodeRepository.findById(id);
	}
	
	public void deleteNodeById(Long id){
		nodeRepository.deleteById(id);
	}
	
	public Node updateNode(Long id){
		return null;
	}
	
	public List<Node> getAllNodes(){
		return nodeRepository.findAll();
	}
}

