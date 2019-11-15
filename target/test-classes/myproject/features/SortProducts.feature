Feature: Add products to cart

  Scenario Outline: User should be able to add different products to the cart in different ways
    Given user goes to the http://automationpractice.com main page
    And he searches for <product> product
    When he sorts products by <sortOption>
    Then products are sorted by <sortOption>

    Examples:
      | product | sortOption           |
      | dress   | Price: Lowest first  |
      | dress   | Product Name: A to Z |
