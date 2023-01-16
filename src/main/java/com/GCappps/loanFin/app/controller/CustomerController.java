package com.GCappps.loanFin.app.controller;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.GCappps.loanFin.app.model.Customer;
import com.GCappps.loanFin.app.model.Documents;
import com.GCappps.loanFin.app.responce.BaseResponce;
import com.GCappps.loanFin.app.serviceI.CustomerServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/GCappps")
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	CustomerServiceI customerServiceI;

	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<BaseResponce<Customer>> saveCustomer(
			@RequestPart(value = "pancard") MultipartFile pancard,
			@RequestPart(value = "adharcard") MultipartFile adharcard,
			@RequestPart(value = "photo") MultipartFile photo,
			@RequestPart(value = "signature") MultipartFile signature,
			@RequestPart(value = "incomeStatement") MultipartFile incomeStatement,
			@RequestPart(value = "customerData") String customerData) {
			ObjectMapper om = new ObjectMapper();
		try {
			Customer customerRead = om.readValue(customerData, Customer.class);

			Customer customer = new Customer();
			// int boundedRandomValue = ThreadLocalRandom.current().nextInt(0, 100);
			// Random CustomerId between 100 to 200
		
			customerRead.setCustomerId("cust-" + ThreadLocalRandom.current().nextInt(100, 200));

			customer.setCustomerId(customerRead.getCustomerId());

			Documents d1 = new Documents();

			d1.setPancard(pancard.getBytes());
			d1.setAdharcard(adharcard.getBytes());
			d1.setPhoto(photo.getBytes());
			d1.setSignature(signature.getBytes());
			d1.setIncomeStatement(incomeStatement.getBytes());
			// customer.setPancard(file2.getBytes());
			customerRead.setCustomerDocuments(d1);

			Customer customer2 = customerServiceI.saveCustomer(customerRead);
			BaseResponce<Customer> base = new BaseResponce<>(201, "Customer Save successfully", customer2);
			return new ResponseEntity<BaseResponce<Customer>>(base, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<BaseResponce<Customer>>(HttpStatus.CONFLICT);
		}

		// return new ResponseEntity<BaseResponce<Customer>>(base, HttpStatus.CREATED);
	}
	@GetMapping("/getAllCustomer/{customerVerificationStatus}")
	public ResponseEntity<BaseResponce<List<Customer>>> getCustomer(@PathVariable String customerVerificationStatus){
		
		List<Customer> list=customerServiceI.getCustomer(customerVerificationStatus);
		BaseResponce<List<Customer>> base=new BaseResponce<>(200,"All customer Fetch by status",list);
		return new ResponseEntity<BaseResponce<List<Customer>>>(base,HttpStatus.OK);
	}
}
