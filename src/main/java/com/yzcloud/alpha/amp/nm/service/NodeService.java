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
	
	public Node create(Node user) {
		return nodeRepository.save(user);
	}
	
	public Optional<Node> delete(int id) {
		Optional<Node> node = findById(new Long(id));
		if(node!= null){
			nodeRepository.delete(node.get());
		}
		return node;
	}
	
	public List findAll() {
		return nodeRepository.findAll();
	}
	
	public Optional<Node> findById(Long id) {
		return nodeRepository.findById(id);
	}
	
	public Node update(Node node) {
		return nodeRepository.save(node);
	}
}

