package com.GCappps.loanFin.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GCappps.loanFin.app.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer	, String> {

	List<Customer> findAllByCustomerVerificationStatus(String customerVerificationStatus);

	
}
