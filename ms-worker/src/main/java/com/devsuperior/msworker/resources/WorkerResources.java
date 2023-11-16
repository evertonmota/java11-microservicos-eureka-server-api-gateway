package com.devsuperior.msworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.msworker.entities.Worker;
import com.devsuperior.msworker.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResources {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(WorkerResources.class);
	
	@Autowired
	private WorkerRepository  repository;
	
	@Value("${test.config}")
	private String testConfig;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id ){
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping(value = "/config")
	public ResponseEntity<Void> getConfig(){
		logger.info("CONFIG ="+testConfig);
		return ResponseEntity.ok().build();
	}
}
