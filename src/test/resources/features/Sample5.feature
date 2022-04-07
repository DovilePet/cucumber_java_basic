@regression @part4
Feature: Introduction to cucumber part 4
  As a test engineer
  I want to be able to write and execute a scenario with steps that have 2 column tables

  Background:
    Given I am on age page

  Scenario: a new scenario with 2-column table
    When I enter values:
      | name | Ann |
      | age  | 5   |
    And I click submit age
    Then I see message: "Hello, Ann, you are a kid"

  Scenario: another new scenario with 2-column table
    When I enter values:
      | name | Bob |
      | age  | 61  |
    And I click submit age
    Then I see message: "Hello, Bob, you are an adult"

  Scenario Outline: a new scenario outline 2
    When I enter values:
      | name | <name> |
      | age  | <age>  |
    And I click submit age
    Then I see message: "<message>"
    Examples:
      | name | age | message                      |
      | Ann  | 5   | Hello, Ann, you are a kid    |
      | Bob  | 61  | Hello, Bob, you are an adult |

# TODO - create Scenario Outline for 'Give us your feedback!' page
  # URL: https://kristinek.github.io/site/tasks/provide_feedback
  # Navigate to page
  # Set Name, Age and Genre
  # - All input MUST be done in single step
  # - All input MUST use Examples for data
  # - Step can use Map or Domain object
  # Click "Send" button and verify that previous input is displayed in correct fields
  @new0407
  Scenario: feedback 1
    Given I am on feedback page
    When I enter input in feedback page
      | name  | John  |
      | age   | 18    |
      | genre | male  |
    And I click send
    Then I can see name "John" in feedback
    And I can see age "18" in feedback
    And I can see genre "male" in feedback

  @new0407
  Scenario Outline: feedback 2
    Given I am on feedback page
    When I enter input in feedback page
      | name  | <name>  |
      | age   | <age>    |
      | genre | <genre>  |
    And I click send
    Then I can see name "<name>" in feedback
    And I can see age "<age>" in feedback
    And I can see genre "<genre>" in feedback
    Examples:
      | name  | age | genre   |
      | Elsa  | 20  | female  |
      | Anna  | 15  | female  |
      | Olaf  | 5   | male    |
