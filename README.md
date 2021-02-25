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
    
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryDataJpaRemoteDbTest {
...
}
    
````

Spring by default create tables inline wiht defined entities. For an embedded database, by default spring.jpa.hibernate.ddl-auto=create-drop; for an real database, by default spring.jpa.hibernate.ddl-auto=none. 

````
spring.jpa.hibernate.ddl-auto=none
spring.datasource.platform=postgres

````

Once hibernate.ddl-auto disabled, Spring will automatically pick up schema.sql and/or data.sql; or schema-{platform}.sql and/or data-{platform}.sql; however, this seems only works for the embedded database, but not the real database. 
 
 
