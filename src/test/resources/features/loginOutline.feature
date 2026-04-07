#Feature: Login
#
#  Scenario Outline: Login con diferentes usuarios
#    Given I am on login page
#    When I login with username "<email>" and password "<password>"
#    Then I should see the "<message>"
#
#    Examples:
#      | email                          | password      | message                              |
#      | testRosi.Automation@gmail.com  | Password@123  | logged-in as Rosi                    |
#      | invalid@gmail.com              | wrongpass     | Your email or password is incorrect! |
##      | testRosi.Automation@gmail.com  | wrongpass     | Invalid credentials                  |