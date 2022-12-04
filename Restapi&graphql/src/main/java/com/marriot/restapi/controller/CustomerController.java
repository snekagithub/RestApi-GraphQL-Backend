package com.marriot.restapi.controller;

import com.marriot.restapi.entity.CustomerEntity;
import com.marriot.restapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public CustomerEntity saveCustomer(@RequestBody CustomerEntity customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{id}")
    public CustomerEntity findCustomerById(@PathVariable("id") Long customerId) {
        return customerService.findCustomerById(customerId);
    }

    @GetMapping("/customerlist")
    public List<CustomerEntity> findCustomerlist() {
        return customerService.findCustomerList();
    }

    @QueryMapping
    public List<CustomerEntity> customers() {
        return customerService.findCustomerList();
    }

    @QueryMapping
    public CustomerEntity customerById(@Argument Long customerId) {
        return customerService.findCustomerById(customerId);
    }
    @MutationMapping
    public CustomerEntity addCustomers(@Argument customerInput input){
        CustomerEntity ce=new CustomerEntity(input.customerId(),input.name(),input.address(),input.phoneNum());
                return customerService.saveCustomer(ce);
    }
    record customerInput(Long customerId,String name,String address,Long phoneNum){

    }
}
