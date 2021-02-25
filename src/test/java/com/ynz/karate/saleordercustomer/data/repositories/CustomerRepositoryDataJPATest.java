package com.ynz.karate.saleordercustomer.data.repositories;

import com.ynz.karate.saleordercustomer.data.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @DataJpaTest by default try to activate an embedded database in memory; so it looks up an dependency H2 package.
 * So if you want the following test that works, you have to include h2 maven dependency in the pom file.
 */
@DataJpaTest
public class CustomerRepositoryDataJPATest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testFindAllMethod() {
        Iterable<Customer> customers = customerRepository.findAll();
        assertNotNull(customers);
        List<Customer> customerList = new ArrayList<>();
        customers.forEach(customerList::add);

        assertThat(customerList, hasSize(3));
    }

    @Test
    void testInsertCustomerIntoH2DB() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setFirstName("Mike");
        customer.setLastName("Brown");
        Customer saved = customerRepository.save(customer);
        assertNotNull(saved);
        assertThat(saved.getFirstName(), is("Mike"));

        Optional<Customer> found = customerRepository.findById(1L);
        assertTrue(found.isPresent());
        assertThat(found.get().getFirstName(), is("Mike"));
    }

}
