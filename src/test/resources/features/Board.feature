@createBoard
Feature: Board
  Background:
    Given I have a valid account on Kanban Tool
    And I login with user ”PenielDamian” with password “Control123”
  https://penieldamian.kanbantool.com/login

  Scenario:  Create a new Board
    Given I am in the Dashboard section
    When I want to create a new Kanban board
    Then I have to select Create new board
    And I have to assigned a name
    And I choose a template
    When I create a new board
    Then the board columns is displayed on the window
    And the board name is displayed on Dashboard section


  @DeleteBoard
  Feature: Board
  Background:
    Given I have a valid account on Kanban tool
    And I login with user ”PenielDamian” with password “Control123”
  https://penieldamian.kanbantool.com/login


  Scenario: Delete a Board
    Given I am in the Dashboard section
    When I want to delete a board
    Then I have to select delete on more options
    And I have to confirm to delete
    When I delete a Board
    Then the board name should be remove to Dashboard

  @CloneBoard
  Feature: Board
  Background:
    Given I have a valid account on Kanban tool
    And I login with user ”PenielDamian” with password “Control123”
  Scenario: Clone a Board
    Given: I am in the Dashboard section
    When I want to clone a board
    Then I have to select clone on more options
    And I have to assig a new name for the new board
    And I have to confirm the cloning
    When I cloned a board
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

    ///////////////
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
