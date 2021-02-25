package com.ynz.karate.saleordercustomer.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    private Long customerId;

    private String firstName;
    private String lastName;

}
