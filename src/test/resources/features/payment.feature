Feature: Checkout Management

  Background:
    Given Add new product
    And The user is on the checkout page

  Scenario:  Proceed to Checkout
    When The user clicks the Proceed to Checkout button
    And The user review the order and place order
    And The user enters the information to complete the payment
    Then The