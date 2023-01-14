package com.GCappps.loanFin.app.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.GCappps.loanFin.app.model.EnquiryDetails;
import com.GCappps.loanFin.app.repository.EnquiryRepository;
import com.GCappps.loanFin.app.serviceI.EnquiryServiceI;

@Service
public class EnquiryServiceImpl implements EnquiryServiceI {

	@Autowired
	EnquiryRepository enquiryRepository;
	Random r = new Random(999);

	public EnquiryDetails customerEnquiry(EnquiryDetails enquiryDetails) {

		enquiryDetails.setEnquiryId("GCappps-Enq-" + r.nextInt(9999));//
		enquiryDetails.setEnquiryStatus("enquiry");
		EnquiryDetails enquiryDetails2 = enquiryRepository.save(enquiryDetails);
		return enquiryDetails2;
	}

	public Optional<EnquiryDetails> customerLogin(String enquiryId) {

		return enquiryRepository.findById(enquiryId);
	}

	@Override
	public List<EnquiryDetails> customerEnquiries(String enquiryStatus) {

		return enquiryRepository.findAllByEnquiryStatus(enquiryStatus);
	}

	@Override
	public Optional<EnquiryDetails> cibilScoreCheck(String enquieryId) {

		return enquiryRepository.findById(enquieryId);
	}

	public EnquiryDetails updateEnquiry(EnquiryDetails enquiryDetails) {
		enquiryDetails.setEnquiryStatus("Enquired");
		EnquiryDetails enquiryDetails2 = enquiryRepository.save(enquiryDetails);
		return enquiryDetails2;
	}

}
