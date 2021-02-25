# sale-order-customer

How to replace @DataJpaTest embedded database; how to run integration tests against both an embedded database and a real database. 

@DataJpaTest

It is an annotation for a tailored integration test and minimised enough for testing the target repository.

It includes @AutoConfigureTestDatabase. By default, it auto-config an embedded database, so it needs a database dependency like h2 in the pom. You also can disable it and making a test against a real database.

````
AutoConfigureTestDatabase.Replace replace() default AutoConfigureTestDatabase.Replace.ANY;

    public static enum Replace {
        ANY,
        AUTO_CONFIGURED,
        NONE;

        private Replace() {
        }
    }
````

Spring by default create tables inline wiht defined entities. For an embedded database, by default spring.jpa.hibernate.ddl-auto=create-drop; for an real database, by default spring.jpa.hibernate.ddl-auto=none. 

````
spring.jpa.hibernate.ddl-auto=none

````
 
 
