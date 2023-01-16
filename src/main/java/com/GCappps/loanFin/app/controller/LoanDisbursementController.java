package com.GCappps.loanFin.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GCappps.loanFin.app.LoanDisbursementserviceI;
import com.GCappps.loanFin.app.model.Customer;
import com.GCappps.loanFin.app.model.LoanDisbursement;
import com.GCappps.loanFin.app.responce.BaseResponce;

@RestController
@CrossOrigin("*")
@RequestMapping("/GCappps")
public class LoanDisbursementController {
	
	@Autowired
	LoanDisbursementserviceI loandisb;
	
	@PostMapping("/loandisburse")
	public ResponseEntity<BaseResponce<LoanDisbursement>> loandisbursement(@RequestBody Customer customer){
		LoanDisbursement loandisuDisbursement=loandisb.loandisbursement(customer);
		BaseResponce<LoanDisbursement> base=new BaseResponce<>(200,"Loan Disbursement letter is generated",loandisuDisbursement);
		return new ResponseEntity<BaseResponce<LoanDisbursement>>(base,HttpStatus.OK);
	}

}
