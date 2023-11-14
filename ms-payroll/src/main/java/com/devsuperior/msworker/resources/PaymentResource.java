package com.devsuperior.msworker.resources;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.msworker.entities.Payment;
import com.devsuperior.msworker.services.PaymentService;

@RestController
@RequestMapping(value= "/payments")
public class PaymentResource {

	private org.slf4j.Logger logger = LoggerFactory.getLogger(PaymentResource.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	public PaymentService service;
	
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		
		logger.info("PORT = " +env.getProperty("local.server.port"));
		
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
	
}
