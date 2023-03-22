package com.allane.leasing.contracts.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allane.leasing.contracts.model.CustomerDto;
import com.allane.leasing.contracts.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping("/")
	public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.createCustomer(customerDto);
	}

	@GetMapping("/{customerId}")
	public CustomerDto getCustomer(@PathVariable String customerId) {
		return customerService.getCustomer(customerId);
	}

	@PutMapping("/{customerId}")
	public CustomerDto updateCustomer(@PathVariable String customerId, @RequestBody CustomerDto customerDto) {
		return customerService.updateCustomer(customerId, customerDto);
	}

	@DeleteMapping("/{customerId}")
	public void deleteCustomer(@PathVariable String customerId) {
		customerService.deleteCustomer(customerId);
	}

}
