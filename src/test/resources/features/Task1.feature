Feature: Practical task 1
  #url: "https://kristinek.github.io/site/tasks/enter_a_number"
  #Scenario outline for error cases:
  #enter number too small
  #enter number too big
  #enter text instead of the number
  #Scenario for correct number

  Background:
    Given I am on Enter Number page

  Scenario Outline: incorrect data
    When I enter string "<string>"
    And I click submit
    Then I get error message: "<error>"
    Examples:
    | string  | error                 |
    | 10      | Number is too small   |
    | 200     | Number is too big     |
    | txt     | Please enter a number |

  Scenario: correct data
    When I enter number 64
    And I click submit
    Then result is displayed in alert window
