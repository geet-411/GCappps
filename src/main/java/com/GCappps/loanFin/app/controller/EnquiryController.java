package com.GCappps.loanFin.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GCappps.loanFin.app.model.EnquiryDetails;
import com.GCappps.loanFin.app.serviceI.EnquiryServiceI;

@RestController
@RequestMapping("/GCappps")
public class EnquiryController {

	@Autowired
	EnquiryServiceI enquiryServiceI;
		
	@PostMapping("/enquiry")
	public ResponseEntity<EnquiryDetails> customerEnquiry(@RequestBody EnquiryDetails enquiryDetails) {

		EnquiryDetails enquiryDetails2 = enquiryServiceI.customerEnquiry(enquiryDetails);

		return new ResponseEntity<EnquiryDetails>(enquiryDetails2,HttpStatus.CREATED);
	}
}
