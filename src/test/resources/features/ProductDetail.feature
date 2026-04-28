Feature: Detail Product
  Background:
#    Given The user is on the Product page
    Given The user has logged in successfully
    And You are on the Product page

  Scenario: Increment the quantity of the product
    When The user select View Product link
    And Increase the quantity of the product by 3
    Then The product quantity is now shown as increased
    