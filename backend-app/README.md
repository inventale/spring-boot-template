This module contains Spring Dependency Injection configuration and Web endpoints.
The main idea is not to mix business logic (see backend module) and DI configuration.
 
***HelloWorldAppAcceptanceTest*** 

This test checks that Spring configuration is valid and HTTP endpoints work correctly.
Business logic can be tested in unit tests of according module. 