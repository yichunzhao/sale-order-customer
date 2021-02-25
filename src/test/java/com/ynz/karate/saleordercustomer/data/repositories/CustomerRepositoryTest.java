package com.ynz.karate.saleordercustomer.data.repositories;

import com.ynz.karate.saleordercustomer.data.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testGetCustomersFromRemoteDB() {
        Iterable<Customer> customers = customerRepository.findAll();

        List<Customer> customerList = new ArrayList();
        customers.forEach(Customer -> customerList.add(Customer));

        assertThat(customerList, hasSize(6));
    }

    @Test
    @Transactional
    void testSaveCustomerAgainstRemoteDB() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setFirstName("Mike");
        customer.setLastName("Brown");

        Customer savedCustomer = customerRepository.save(customer);
        assertNotNull(savedCustomer);
        assertThat(savedCustomer.getFirstName(), is("Mike"));
    }

}