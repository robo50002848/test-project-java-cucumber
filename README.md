# java-cucumber-maven

README.md

This is the project from test automation area.
Technologies: Java, Maven, Selenium WebDriver, Selenium Grid, JUnit, BDD (Cucumber)

Running the tests:
Test are run by maven command on specified environment: on local machine or on Selenium Grid.

If you want to use Selenium Grid, you must setup hub and node on your machine and then pass your Selenium Grid hub URL as maven parameter.

Default values in POM.xml are:

environment=local
seleniumGridUrl=http://localhost:4444/wd/hub

Maven command examples:

- run tests on local machine: 					mvn test
- run tests on Selenium Grid with default URL: 	mvn test -Denvironment=seleniumGrid
- run tests on Selenium Grid with custom URL: 	mvn test -Denvironment=seleniumGrid -DseleniumGridUrl={your_selenium_grid_url}

IMPORTANT: 

First test case in sortProducts.feature (Price: Lowest first) is failing because of not logical application implementation. When you sort searched products by: Price: Lowest first, you can see, that also old prices (before discount) are considered in this kind of sorting. In my opinion only bold prices should be considered.
