@Board
Feature: Board
  Background:
    Given I navigate to Login page
    When I login as "Damian.Villanueva@fundacion-jala.org" with password "Control123"


  @MoveTask
  Scenario Outline: User Should be able to move a Task
    Given I navigate to Dashboard page
      And I create a new board with the following details: Board Name: "<Board Name>", description: "<Board Description>", template: "<Board Template>"
    And I have a Board created with the following details:.......
    And I have a task created on "<Column Name>" Column
    When I move the task from "<Column Name>" to "<Column Destine>"
    Then  the Task should be displayed on the Column "<Column Destine>"
  Examples:
    |Board Name            |Board Description   |Board Template   |
    |BoardSimpleBasic      |This a test Board   |simple basic     |
  Examples:
    |Column Name     |Column Destine     |
    |To do           |In Progress        |




  @ColumnTasks
  Scenario Outline: User should be able view the
    Given I have a Board created with the following details:.......
      And I create "<Task Quantity>" Tasks  created on the board on the column "<Column Name>"
    When I move the "<Task Quantity>" from "<Column Name>" to "<Column Destine>"
    Then I should be able view the "<Task Quantity>" label on the "<Column Destine>"
    And the number Column should display the correct quantity "<Task Quantity>"
    And the number Column should be displayed to color red if the quantity exceeds to permitted

  Examples:
    |Task Quantity    |Column Name     |Column Destine     |column |
    |2                |


















  @DeleteBoard
  Feature: Board
  Background:
    Given I have a valid account on Kanban tool
    And I login with user ”PenielDamian” with password “Control123”
  https://penieldamian.kanbantool.com/login


  Scenario: Delete a Board
    Given I navigate to Dashboard page
      And  I have to a board created
    When I deleted a Board
    Then the board name should be remove to Dashboard

  @CloneBoard
  Feature: Board
  Background:
    Given I have a valid account on Kanban tool
    And I login with user ”PenielDamian” with password “Control123”
  Scenario: Clone a Board
    Given I navigate to Dashboard page
      And I have to a board created
    When I cloned the board
    Then the name board cloned should be display in the Dashboard section
      And the board cloned structure should be same to original board

  @renameBoard
  Feature: Board
  Scenario: rename a Board
    Given: I am in the Dashboard section
    When I want to rename a board
    Then I have to select Rename on more options
    And I have to assig a different name
    And I have to save too changes
    When I rename a Board
    Then the new name board should be display on the Dashboard section

  @reorderItems
  Feature: Board
  Scenario: As account admin, you can reorder items to suit your needs
    Given I have four boards on the Dasboard
    When I want to reorder boards items
    Then I have to select Reorder items
      And I have to move from top to bottom the items

/////
    When I reorder the items
    Then the Boards list should be same reorders

  @share
  Feature Board
    Scenario select people to board
      Given  I have board create
        And I have "num_people" added in the board
      When I want to shared the board with people
      Then I have to select member to the people list
        And I have to assign permission level to every people selected
        And I have to save changes
      When I shared the board with peoples
      Then the message "name board" board is now shared with "numPeople" people should be display in the window
      And
