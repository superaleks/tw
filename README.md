# Trust Wallet Automated tests - Web extension

It is possible to create tests for Web Extensions too! 
This project is testing the Crypto wallet Web extension called Trust Wallet.

## Getting Started

You will need Java, Selenium and Maven in order to run this project.

### Dependencies

* Java 
* Maven
* Selenium Webdriver

### Installing

* `mvn install`
Then, run the main class of this project. That's it! 

### Running

1. Open main/java folder to find test code
2. In order to run the test, execute the main method which is named `Test`
3. In order to check the rest of the code: check Helper and PageObject


I've created PageObject class in order to extract locators from the test and enable cleaner code.
Next logical step would be to implement a test framework like TestNG or JUnit. 