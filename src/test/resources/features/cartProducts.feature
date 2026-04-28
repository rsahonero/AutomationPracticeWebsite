Feature: Cart Management

  Background:
    Given Add new product
    And The user is on the Cart page

  Scenario: Remove a product from the Cart page
    When Click the X icon to remove the product
    Then The product is no longer visible on the page

