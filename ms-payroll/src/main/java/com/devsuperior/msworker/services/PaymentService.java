package com.devsuperior.msworker.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.msworker.entities.Payment;
import com.devsuperior.msworker.entities.Worker;

@Service
public class PaymentService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${ms-worker.host}")
	private String msWorkerHost;
	
	public Payment getPayment(long workerId, int days) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId );
		
		Worker worker = restTemplate.getForObject(msWorkerHost + "/workers/{id}", Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
