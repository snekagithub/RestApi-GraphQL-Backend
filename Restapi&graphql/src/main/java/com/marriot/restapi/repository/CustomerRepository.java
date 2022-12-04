package com.marriot.restapi.repository;

import com.marriot.restapi.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface CustomerRepository  extends JpaRepository<CustomerEntity,Long> {
    CustomerEntity findByCustomerId(Long customerId);

    }

