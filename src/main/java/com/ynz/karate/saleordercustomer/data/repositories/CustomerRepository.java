package com.ynz.karate.saleordercustomer.data.repositories;

import com.ynz.karate.saleordercustomer.data.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
