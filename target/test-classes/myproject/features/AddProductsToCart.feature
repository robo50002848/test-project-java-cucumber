Feature: Add products to cart

  Scenario Outline: User should be able to add different products to the cart in different ways
    Given user goes to the http://automationpractice.com main page
    And he searches for <product> product
    And he adds product number 1 to the cart
    And he adds product number 2 to the cart from product's details page
    When he goes to the cart
    Then he should see 2 products added to the cart

    Examples:
      | product |
      | dress   |