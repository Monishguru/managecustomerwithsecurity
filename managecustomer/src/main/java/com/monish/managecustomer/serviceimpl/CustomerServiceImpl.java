package com.monish.managecustomer.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.monish.managecustomer.entity.Customer;
import com.monish.managecustomer.exception.InvalidInputException;
import com.monish.managecustomer.repository.CustomerRepository;
import com.monish.managecustomer.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		log.info("Saving in progress...");
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerByID(Long id) {
		log.info("Getting Customer by id.");
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			return customer.get();
		}
			
		else {
			throw new EmptyResultDataAccessException("No Record found", 1);
		}

	}

	@Override
	public Customer getCustomerByName(String name) {
		log.info("Getting Customer by first name or last name.");
		return customerRepository.findByFirstNameOrLastName(name, name);
	}

	@Override
	public void deleteCustomer(Long id) {
		log.info("Deleting customer by id {}", id);
		customerRepository.deleteById(id);

	}

	@Override
	public Customer updateCustomer(Customer customer) {
		if (customer.getId() != null) {
			return customerRepository.save(customer);
		} else {
			throw new InvalidInputException("Id is Mandatory to update");
		}
	}

}
