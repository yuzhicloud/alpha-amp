package com.yzcloud.alpha.amp.web.nm;

import com.yzcloud.alpha.amp.nm.domain.Node;
import com.yzcloud.alpha.amp.nm.service.NodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/nm")
public class NodeController{
	private final Logger log = LoggerFactory.getLogger(NodeController.class);
	
	private final NodeService nodeService;
	
	public NodeController(NodeService nodeService){
		this.nodeService = nodeService;
	}
	
	@PostMapping
	public Node create(@RequestBody Node node){
		return nodeService.create(node);
	}
	
	@GetMapping(path = {"/{id}"})
	public Optional<Node> findOne(@PathVariable("id") int id){
		return nodeService.findById(new Long(id));
	}
	
	@PutMapping(path ={"/{id}"})
	public Node update(@PathVariable("id") int id, @RequestBody Node node){
		return nodeService.update(node);
	}
	
	@DeleteMapping(path ={"/{id}"})
	public Optional<Node> delete(@PathVariable("id") int id) {
		return nodeService.delete(id);
	}
	
	@GetMapping
	public List findAll(){
		return nodeService.findAll();
	}
}

