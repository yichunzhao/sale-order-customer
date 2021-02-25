package com.ynz.karate.saleordercustomer.data.repositories;


import com.ynz.karate.saleordercustomer.data.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

/**
 * stop DataJPATest from auto-configuring embedded database. So it will use remote db.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryDataJpaRemoteDbTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testFindAllCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        List<Customer> customerList = new ArrayList<>();
        customers.forEach(customerList::add);
        assertThat(customerList, hasSize(6));
    }

}
