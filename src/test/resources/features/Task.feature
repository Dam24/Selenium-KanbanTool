@Tasks
Feature: tasks


  Background:
#    Given I login as "Damian.Villanueva@fundacion-jala.org" with password "Control123"
    Given I login as "penieldvp18@gmail.com" with password "Control123"

  @addTask
  Scenario Outline: add a task on the board
    Given I navigate to Dashboard page
    And I create a new board with the following details: Board Name: "<Board Name>", description: "<Board Description>", template: "<Board Template>"
    When I added a new task in the Column "<Column Name>" with the following details: "<Task Name>"
    Then the "<Task Name>" task should be displayed on the "<Column Name>" column
  Examples:
    |Column Name  |Task Name  |Board Name         |
    |Done         |Task1      |BoardToCreateTask  |

  @editTask
  Scenario Outline: User should be able edit a task
    Given I navigate to Dashboard page
    And I create a new board with the following details: Board Name: "<Board Name>", description: "<Board Description>", template: "<Board Template>"
    And I added a new task in the Column "<Column Name>" with the following details: "<Task Name>"
    When I edited in the column "<Column Name>" the Task name from "<Task Name>" to "<New Task Name>"
    Then the "<New Task Name>" task should be displayed on the "<Column Name>" column

  Examples:
    |Column Name  |Task Name  |New Task Name    |Board Name       |
    |Done         |Task1      |NewTask1         |BoardToEditTask  |
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
#  Scenario Outline: delete a task
#    Given I navigate to Dashboard page
#      And I create a new board with the following details: Board Name: "<Board Name>", description: "<Board Description>", template: "<Board Template>"
#      And I added a new task in the Column "<Column Name>" with the following details: "<Task Name>"
#    When I delete the Task "<Task Name>" to the column "<Column Name>"
#    Then the Task "<Task Name>" not should be displayed on the column "<Column Name>"
#  Examples:
#  |Column Name  |Task Name  |
#  |Done         |Task1      |


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