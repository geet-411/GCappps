package com.GCappps.loanFin.app.serviceI;

import java.util.List;

import com.GCappps.loanFin.app.model.Customer;

public interface CustomerServiceI {

public	Customer saveCustomer(Customer customer);

public List<Customer> getCustomer(String customerVerificationStatus);

}
