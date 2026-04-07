Feature: Login

Scenario: Login
  Given I am on login Page
  When I login with the username and password
  Then I should see the "Logged in as " of the logged-in user

