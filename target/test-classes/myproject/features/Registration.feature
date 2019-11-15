Feature: Registration

  Scenario: User should be able to register to the application with proper data
    Given user goes to the http://automationpractice.com main page
    When he goes to the authentication page
    And he fills the form with default data
    Then he is logged in and my account page is displayed