# sale-order-customer
How to replace @DataJpaTest embedded database

@DataJpaTest

It is an annotation for an integration test of repositories. It is a tailored integration test and minimised enough for testing the target repository.

By default, it auto-config an embedded database, so it needs a database dependency like h2 in the pom. You also can disable it to auto-config an embedded database, and making a test against a real database.
