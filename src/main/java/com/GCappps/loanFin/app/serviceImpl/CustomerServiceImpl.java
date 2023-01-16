package com.GCappps.loanFin.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GCappps.loanFin.app.model.Customer;
import com.GCappps.loanFin.app.repository.CustomerRepository;
import com.GCappps.loanFin.app.serviceI.CustomerServiceI;

@Service
public class CustomerServiceImpl implements CustomerServiceI {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		
		return customerRepository.save(customer) ;
	}

	@Override
	public List<Customer> getCustomer(String customerVerificationStatus) {
		
		
		
		return customerRepository.findAllByCustomerVerificationStatus(customerVerificationStatus);
	}

}
