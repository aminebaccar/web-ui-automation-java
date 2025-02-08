Feature: Validate Products Page

  Scenario: Verify products page loads correctly
    Given I navigate to the homepage
    And Only necessary cookies are accepted
    When I hover over the "Products" menu
    And I click on the "Power Systems" category
    Then I verify that products are displayed
    And I verify each product has a title and description
    When I click on Read more for the first product
    Then I should be redirected to the product details page