Feature: Search engine

  Scenario Outline: User should be able to search for products
    Given user goes to the http://automationpractice.com main page
    When he searches for <product> product
    Then he should see results

    Examples:
      | product |
      | dress   |