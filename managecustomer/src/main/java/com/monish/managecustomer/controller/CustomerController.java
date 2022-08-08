package com.monish.managecustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monish.managecustomer.entity.Customer;
import com.monish.managecustomer.serviceimpl.CustomerServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/customer")
@Slf4j
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerServiceImpl;

	@PostMapping(value = "/save")
	@Operation(summary="This will help to save customer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		if(customer==null) {
			throw new NullPointerException();
			}
		log.info("Got a request to save customer: {}", customer);
		return customerServiceImpl.saveCustomer(customer);

	}

	@GetMapping(value = "/getById")
	@Operation(summary="This will help to get customer by Id")
	public Customer getCustomerById(@RequestParam(value = "id") Long id) {
		log.info("Got a request to get customer by id : {}", id);
		return customerServiceImpl.getCustomerByID(id);
	}

	@Operation(summary="This is deprecated",deprecated = true)
	@RequestMapping(method = RequestMethod.GET, value = "/getByName")
	public Customer getCustomerByName(@RequestParam(value = "name") String name) {
		log.info("Got a request to get customer by name : {}", name);
		return customerServiceImpl.getCustomerByName(name);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete")
	public void deleteCustomer(@PathVariable(value = "id") Long id) {
		log.info("Got a request to delete customer by id : {}", id);
		customerServiceImpl.deleteCustomer(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public Customer updateCustomer(@RequestBody Customer customerToUpdate) {
		log.info("Got a request to update customer: {}", customerToUpdate);
		return customerServiceImpl.updateCustomer(customerToUpdate);

	}
	
}
