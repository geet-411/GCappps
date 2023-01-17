package com.GCappps.loanFin.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GCappps.loanFin.app.model.Customer;

@Repository
<<<<<<< Updated upstream
public interface CustomerRepository extends JpaRepository<Customer,String> {
=======
public interface CustomerRepository extends JpaRepository<Customer, String> {
>>>>>>> Stashed changes

public	List<Customer> findAllByCustomerVerificationStatus(String customerVerificationStatus);

public Optional<Customer> findByCustomerId(String customerId);

}
