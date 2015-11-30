@Board
Feature: Board
  Background:
    Given I navigate to Login page
    When I login as "Damian.Villanueva@fundacion-jala.org" with password "Control123"


  @MoveTask
  Scenario Outline: User Should be able to move a Task
    Given I navigate to Dashboard page
      And I create a new board with the following details: Board Name: "<Board Name>", description: "<Board Description>", template: "<Board Template>"
    And I create a new board with the following details: Board Name: "<Board Name>", description: "<Board Description>", template: "<Board Template>"
    And I added a new task in the Column "<Column Name>" with the following details: "<Task Name>"
    When I move the task "<Task Name>" from "<Column Name>" to "<Column Destine>"
    Then the "<Task Name>" task should be displayed on the "<Column Destine>" column

  Examples: board
    |Board Name            |Board Description   |Board Template   |Column Name     |Column Destine     |Column Name  |Task Name  |
    |BoardSimpleBasic      |This a test Board   |simple basic     |To do           |In Progress        |Done         |Task1      |





#  @ColumnTasks
#  Scenario Outline: User should be able view the
#    Given I have a Board created with the following details:.......
#      And I create "<Task Quantity>" Tasks  created on the board on the column "<Column Name>"
#    When I move the "<Task Quantity>" from "<Column Name>" to "<Column Destine>"
#    Then I should be able view the "<Task Quantity>" label on the "<Column Destine>"
#    And the number Column should display the correct quantity "<Task Quantity>"
#    And the number Column should be displayed to color red if the quantity exceeds to permitted
#
#  Examples:
#    |Task Quantity    |Column Name     |Column Destine     |column |
#    |2                |


