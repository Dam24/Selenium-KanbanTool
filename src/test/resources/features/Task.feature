@Tasks
Feature: tasks

  Background:
    Given I navigate to Login page
    When I login as "Damian.Villanueva@fundacion-jala.org" with password "Control123"

#  @addTask
#  Scenario Outline: add a task on the board
#    Given I navigate to Dashboard page
#    And I create a new board with the following details: Board Name: "<Board Name>", description: "<Board Description>", template: "<Board Template>"
#    When I added a new task in the Column "<Column Name>" with the following details: "<Task Name>"
#    Then the new "<Task Name>" task should be displayed on the "<Column Name>" column
#  Examples:
#  |Column Name  |Task Name  |description     |cardType    |priority|estimated  |Difficulty|
#  |Done         |Task1      |this is a task  |yellow      |high    |           |          |
#  |In Progress  |Task2     |this is a task  |strong_red  |normal  |           |          |
#  |Done         |Task3     |this is a task  |pink        |low     |           |          |
#  |To do        |Task4     |this is a task  |violet      |high    |           |          |

  @editTask
  Scenario Outline: User should be able edit a task
    Given I navigate to Dashboard page
    And I create a new board with the following details: Board Name: "<Board Name>", description: "<Board Description>", template: "<Board Template>"
    And I added a new task in the Column "<Column Name>" with the following details: "<Task Name>"
    When I edited in the column "<Column Name>" the Task name from "<Task Name>" to "<New Task Name>"
    Then Then the new "<New Task Name>" task should be displayed on the "<Column Name>" column

  Examples:
  |Column Name  |Task Name  |New Task Name    |
  |Done         |Task1      |NewTask1         |
#
#
#
#  @duplicateTask
#  Feature task
#  Scenario duplicate a task
#    Given I have a board created
#      And I have a task added on the board
#    When I duplicate a task
#    Then I should be able view the duplicate task on same column to original task
#      And the duplicate task should be equal to original task
#
#  @deleteTask
#  Feature task
#  Scenario delete a task
#    Given I have to a board created
#    And I have to a Task added on the board
#    When I delete the task
#    Then the task deleted not should display on the column "column name" on the board
#
#
#  @assignTask
#  Feature task
#  Scenario assign a task
#    Given I have to a board created
#    And I have to a Task added on the board
#    When I assigneed a task to team member
#    Then the initial name should display on the below task on the board
#
#  @changePriority
#  Feature task
#  Scenario change pri
#  @chance type task
#  @moveTask
#  Feature task
#  Scenario move a task to column "column_name1" to "column_name2"
#    Given I have a board created
#    And I have a task added on the board
#    When I want to move a task
#    Then
#  @move to task
#  @add to  my work task
#  @archiveTask
#  Feature task
#  Scenario archive task
#    Given I have a board created
#    And I have a task added on the board
#    When I want a archive a task
#    Then