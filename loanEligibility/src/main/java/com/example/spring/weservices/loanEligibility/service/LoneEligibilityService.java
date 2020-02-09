package com.example.spring.weservices.loanEligibility.service;

import java.util.List;

import org.example.loaneligibility.Acknowledgement;
import org.example.loaneligibility.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class LoneEligibilityService {
	
	
	public Acknowledgement checkLoanEligibilty(CustomerRequest request) {
		Acknowledgement ac=new Acknowledgement();
		List<String>mismatchCriteriaList=ac.getCriteriaMismatch();
		
		if(!(request.getAge()>30 && request.getAge()<=60)){
			mismatchCriteriaList.add("Person age should in beteween 30 to 60");
		}
        if(!(request.getYearlyIncome()>200000)) {
        	mismatchCriteriaList.add("minimun income should be more than 200000");
        }
        
        if(!(request.getCibilScore()>500)) {
        	mismatchCriteriaList.add("Low CIBIL Score please try later");
        }
		
        if(mismatchCriteriaList.size()>0) {
        	ac.setApprovedAmount(0);
        	ac.setIsEligible(false);
        }else {
        	ac.setApprovedAmount(500000);
        	ac.setIsEligible(true);
        	mismatchCriteriaList.clear();
        }
        return ac;
	} 

}
