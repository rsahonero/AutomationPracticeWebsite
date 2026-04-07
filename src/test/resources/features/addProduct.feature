Feature: Product Management
  As an admin user
  I want to manage products in the inventory
  So that I can keep the catalog updated

  Background:
    Given The user has logged in successfully
    And You are on the Product page

#  @smoke @regression
  Scenario: Add a new product with complete information
    When click the "Add to cart" button
    Then A success message should be displayed "Your product has been added to cart."
#    And el nuevo producto debería aparecer en la lista de productos


#  Scenario: Remove a product from the checkout page
#    Given I am on the checkout page
#    When Click the X icon to remove the product
#    Then The product is no longer visible on the page