package com.yzcloud.alpha.amp.web.nm;


import com.yzcloud.alpha.amp.nm.domain.Node;
import com.yzcloud.alpha.amp.nm.repository.NodeRepository;
import com.yzcloud.alpha.amp.nm.service.NodeService;
import com.yzcloud.alpha.amp.web.error.BadRequestAlertException;
import com.yzcloud.alpha.amp.web.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.LogManager;

@RestController
@RequestMapping("/api")
public class NodeController{
	private final Logger log = LoggerFactory.getLogger(NodeController.class);
	
	private final NodeService nodeService;
	
	private final NodeRepository nodeRepository;
	
	public NodeController(NodeService service,NodeRepository nodeRepository){
		this.nodeService = service;
		this.nodeRepository = nodeRepository;
	}
	
	
	@PostMapping("/nodes")
	public ResponseEntity<Node> createNode(@Valid @RequestBody Node node) throws URISyntaxException {
		log.debug("REST request to save node: {}",node );
		
		Long id  = 0L;
		if (node != null) {
			throw new BadRequestAlertException("A new user cannot already have an ID", "userManagement", "idexists");
			// Lowercase the user login before comparing with database
		}else {
			Node newNode = null;//nodeService.getNodeById(id);
			return ResponseEntity.created(new URI("/api/users/" + newNode.getId()))
				.headers(HeaderUtil.createAlert( "userManagement.created", newNode.getName()))
				.body(newNode);
		}
	}
}

