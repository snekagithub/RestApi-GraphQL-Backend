package com.marriot.restapi.service;

import com.marriot.restapi.entity.CustomerEntity;
import com.marriot.restapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerEntity saveCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    public CustomerEntity findCustomerById(Long customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

    public List<CustomerEntity> findCustomerList() {
        return customerRepository.findAll();
    }


}
