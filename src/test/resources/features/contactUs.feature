Feature: Contact Us

  Background:
    Given The user has logged in successfully

  Scenario: Contact us form
    When The user is on Contact us page
    And Complete the information in Contact us form
    And Select Ok in the pop up alert
    Then The "Success! Your details have been submitted successfully." message is displayed