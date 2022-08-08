package com.monish.managecustomer.service;

import com.monish.managecustomer.entity.Customer;

public interface CustomerService {
	
	public Customer saveCustomer(Customer customer);
	
	public Customer getCustomerByID(Long id);
	
	public Customer getCustomerByName(String name);
	
	public void deleteCustomer(Long id);
	
	public Customer updateCustomer(Customer customer);

}
