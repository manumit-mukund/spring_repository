package com.spring_boot_saga_orchestrator_pattern.model;

public record PaymentResponse(

		Long orderId, 
		Double amount

) {

}
