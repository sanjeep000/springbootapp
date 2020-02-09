package com.example.spring.weservices.loanEligibility.endpoint;

import org.example.loaneligibility.Acknowledgement;
import org.example.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.spring.weservices.loanEligibility.service.LoneEligibilityService;

@Endpoint
public class LoneEligibilityEndpoint {
	
	private static final String NAMESPACE="http://www.example.org/loanEligibility";
	
	@Autowired
	private LoneEligibilityService loneEligibilityService;
	
	
	@PayloadRoot(namespace=NAMESPACE,localPart="CustomerRequest")
	@ResponsePayload
	public Acknowledgement getLoneEligibility(@RequestPayload CustomerRequest request) {
		 return loneEligibilityService.checkLoanEligibilty(request);
	}

}
