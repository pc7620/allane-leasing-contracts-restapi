package com.allane.leasing.contracts.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.allane.leasing.contracts.model.Customer;
import com.allane.leasing.contracts.model.CustomerDto;
import com.allane.leasing.contracts.model.CustomerRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerService(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customerRepository.save(customer);
        return modelMapper.map(customer, CustomerDto.class);
    }

    public CustomerDto getCustomer(String customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + customerId));
        return modelMapper.map(customer, CustomerDto.class);
    }

    public CustomerDto updateCustomer(String customerId, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + customerId));
        modelMapper.map(customerDto, customer);
        customer.setId(customerId);
        customerRepository.save(customer);
        return modelMapper.map(customer, CustomerDto.class);
    }

    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }

}