Feature: Checkout Management

  Background:
    Given The user has logged in successfully
    And Add new product
    And The user is on the Cart page

  Scenario:  Proceed to Checkout
    When The user clicks the Proceed to Checkout button
    And The user review the order and place order
    And The user enters the information to complete the payment
    Then The "Congratulations! Your order has been confirmed!" message should be displayed