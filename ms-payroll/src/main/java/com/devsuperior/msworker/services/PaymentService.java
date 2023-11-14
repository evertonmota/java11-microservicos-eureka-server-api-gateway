package com.devsuperior.msworker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.msworker.entities.Payment;
import com.devsuperior.msworker.entities.Worker;
import com.devsuperior.msworker.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient feignClient;

	public Payment getPayment(long workerId, int days) {
		Worker worker = feignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(),days);
	}

	

}
