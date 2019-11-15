Feature: Login

  Scenario Outline: User should be able to log in to the application with proper credentials
    Given user goes to the http://automationpractice.com main page
    When he goes to the authentication page
    When he logs in with <login> and <password> credentials
    Then he is logged in and my account page is displayed

    Examples:
      | login                           | password |
      | defnrbjefkdm3848@mailinator.com | rrrrr    |