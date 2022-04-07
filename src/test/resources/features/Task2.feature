Feature: practical task 2

  #add a new person
  #edit a person
  #remove a person
  #reset original list after:
  #  adding a person
  #  editing a person
  #  removing a person
  #check that clear button on adding a user works correctly

  Background:
    Given I am on people list page
    Given I have original list

  Scenario: add a new person
    When I click Add person button
    And I enter input of a new person
      | name  | Jonas  |
      | job   | tester |
    And I click Add button
    Then I can see name "Jonas" and job "tester"

    Scenario Outline: edit a person
      When I click on the first pencil icon
      And I enter persons name "<name>"
      And I enter job title "<job>"
      And I click Edit button
      Then I can see name "<name>" and job "<job>"
      Examples:
      | name  | job       |
      | Anna  | princess  |
      | Elsa  | queen     |

    Scenario: remove a person
      When I click on the second x sign
      Then I cannot see the second person anymore


    Scenario: reset original list after adding
      When I click Add person button
      And I enter input of a new person
        | name  | Jonas  |
        | job   | tester |
      And I click Add button
      And I click Reset List button
      Then I cannot see name "Jonas" and job "tester"

    Scenario Outline: reset original list after editing
      When I click on the first pencil icon
      And I enter persons name "<name>"
      And I enter job title "<job>"
      And I click Edit button
      And I click Reset List button
      Then I cannot see name "<name>" and job "<job>"
      Examples:
        | name  | job       |
        | Anna  | princess  |
        | Elsa  | queen     |

  Scenario: reset original list after removing
    When I click on the second x sign
    And I click Reset List button
    Then I can see the second person

  Scenario: clear button on adding a user works correctly
    When I click Add person button
    And I enter input of a new person
      | name  | Jonas  |
      | job   | tester |
    And I click Clear all fields button
    Then name and job fields are empty