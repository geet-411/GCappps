package com.GCappps.loanFin.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GCappps.loanFin.app.model.EnquiryDetails;
import com.GCappps.loanFin.app.responce.BaseResponce;
import com.GCappps.loanFin.app.serviceI.EnquiryServiceI;
@CrossOrigin("*")
@RestController
@RequestMapping("/GCappps")
public class EnquiryController {

	@Autowired
	EnquiryServiceI enquiryServiceI;

	@PostMapping("/enquiry")
	public ResponseEntity<BaseResponce<EnquiryDetails>> customerEnquiry(@RequestBody EnquiryDetails enquiryDetails) {

		EnquiryDetails enquiryDetails2 = enquiryServiceI.customerEnquiry(enquiryDetails);
		BaseResponce<EnquiryDetails> base = new BaseResponce<EnquiryDetails>(200, "Data Save Succefully",
				enquiryDetails2);
		return new ResponseEntity<BaseResponce<EnquiryDetails>>(base, HttpStatus.CREATED);
	}

	@GetMapping("/getbyid/{enquiryId}")
	public ResponseEntity<BaseResponce<EnquiryDetails>> customerLogin(@PathVariable String enquiryId) {

		Optional<EnquiryDetails> enquiry1 = enquiryServiceI.customerLogin(enquiryId);
		EnquiryDetails enquiryDetails = enquiry1.get();
		BaseResponce<EnquiryDetails> base = new BaseResponce<EnquiryDetails>(201, "Customer Fetch Succefully",
				enquiryDetails);

		return new ResponseEntity<BaseResponce<EnquiryDetails>>(base, HttpStatus.OK);
	}

	@GetMapping("/getallenquiries/{enquiryStatus}")
	public ResponseEntity<BaseResponce<List<EnquiryDetails>>> customerEnquiries(@PathVariable String enquiryStatus) {

		List<EnquiryDetails> list = enquiryServiceI.customerEnquiries(enquiryStatus);
		BaseResponce<List<EnquiryDetails>> base = new BaseResponce<List<EnquiryDetails>>(201,
				"All Enquired Customer Fetch Succefully", list);
		return new ResponseEntity<BaseResponce<List<EnquiryDetails>>>(base, HttpStatus.OK);
	}

	@PutMapping("/cibilscore/{enquieryId}")
	public ResponseEntity<BaseResponce<EnquiryDetails>> cibilScoreCheck(@PathVariable String enquieryId,
			@RequestBody EnquiryDetails enquiryDetails) {

		Optional<EnquiryDetails> enqu = enquiryServiceI.cibilScoreCheck(enquieryId);
		// EnquiryDetails enquiryDetails = enqu.get();
		if (enqu.isPresent()) {

			EnquiryDetails enquiryDetails2 = enquiryServiceI.updateEnquiry(enquiryDetails);
			BaseResponce<EnquiryDetails> base = new BaseResponce<EnquiryDetails>(201, "Customer Enquired",
					enquiryDetails2);
			return new ResponseEntity<BaseResponce<EnquiryDetails>>(base, HttpStatus.CREATED);
		}

		BaseResponce<EnquiryDetails> base1 = new BaseResponce<EnquiryDetails>(404, "Customer Not Found", null);
		return new ResponseEntity<BaseResponce<EnquiryDetails>>(base1, HttpStatus.NOT_FOUND);
	}
}
