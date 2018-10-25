package com.yzcloud.alpha.amp;

import com.yzcloud.alpha.amp.nm.domain.Node;
import com.yzcloud.alpha.amp.nm.repository.NodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlphaAmpApplication {
	
	private final Logger log = LoggerFactory.getLogger(AlphaAmpApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AlphaAmpApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(NodeRepository repository){
		return (args) -> {
			// save a couple of customers
			repository.save(new Node("nodexx1", "47.106.227.209","","","",""));
			
			// fetch all customers
			log.info("Node found with findAll():");
			log.info("-------------------------------");
			for (Node node: repository.findAll()) {
				log.info(node.toString());
			}
			log.info("");
			
			// fetch an individual customer by ID
			repository.findById(5L)
				.ifPresent(customer -> {
					log.info("Node found with findById(1L):");
					log.info("--------------------------------");
					log.info(customer.toString());
					log.info("");
				});
			
			// fetch customers by last name
			log.info("--------------------------------------------");
			
			//
			//repository.findById("Bauer").forEach(bauer -> {
			//	log.info(bauer.toString());
			//});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			// 	log.info(bauer.toString());
			// }
			log.info("");
		};
	}
}
