@regression
Feature: Introduction to cucumber part 3
  As a test engineer
  I want to be able to write and execute a scenario outline

  @debugs
  Scenario Outline: a new scenario outline
    Given I am on age page
    When I enter name: "<name>"
    And I enter age: <age>
    And I click submit age
    Then I see message: "<message>"
  @working
    Examples:
      | name  | age | message                        |
      | Ann   | 5   | Hello, Ann, you are a kid      |
      | Marry | 50  | Hello, Marry, you are an adult |
      | Bob   | 61  | Hello, Bob, you are an adult   |
  @not_working
    Examples:
      | name | age | message                   |
      | Tom  | 15  | Hello, Tom, you are a kid |

  # TODO - create Scenario Outline for 'Give us your feedback!' page
  # URL: https://kristinek.github.io/site/tasks/provide_feedback
  # Navigate to page
  # Set name and age based on test Examples
  # Click "Send" button and verify that previous input is displayed in correct fields
  Scenario Outline: scenario of feedback
    Given I am on feedback page
    When I enter feedback name: "<name>"
    And I enter feedback age: <age>
    And I click send
    Then I can see name "<name>" in feedback
    And I can see age <age> in feedback
    Examples:
      | name  | age |
      | Elsa  | 20  |
      | Anna  | 15  |
      | Olaf  | 5   |
