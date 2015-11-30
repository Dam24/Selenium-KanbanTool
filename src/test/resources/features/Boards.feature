@Board
Feature: Boards
#  Background:
#    Given I navigate to Login page
#    And I login as "<User Name>" with password "<Password>"
  Background:
    Given I navigate to Login page
    When I login as "Damian.Villanueva@fundacion-jala.org" with password "Control123"
  @createBoard
  Scenario Outline:  User should be able create a new Board
    Given I navigate to Dashboard page
    When I create a new board with the following details: Board Name: "<Board Name>", description: "<Board Description>", template: "<Board Template>"
    Then the Board "<Board Name>" it should be displayed on the window
#    And I should view the Board name "<Board Name>" in the boards list

  Examples:
    |Board Name            |Board Description   |Board Template   |
    |BoardSimpleBasic      |This a test Board   |simple basic     |
#    |BoardTimeDriver       |This a test Board   |time driven      |
#    |BoardEventDriver      |This a test Board   |event driven     |
#    |BoardTeamBasic        |This a test Board   |team basic       |
#    |BoardProductDEV       |This a test Board   |product dev.     |
#    |BoardSalesPipeline    |This a test Board   |sales pipeline   |
#    |BoardOnlineMarketing  |This a test Board   |online marketing |


  @DeleteBoard

  Scenario Outline: User Should be able Delete a Board
    Given I navigate to Dashboard page
    And I create a new board with the following details: Board Name: "<Board Name>", description: "<Board Description>", template: "<Board Template>"
    When I delete the board "<Board Name>"
    Then the board "<Board Name>" not should be displayed on Dashboard List

  Examples:
    |Board Name            |Board Description   |Board Template   |
    |BoardSimpleBasic      |This a test Board   |simple basic     |

  @CloneBoard
  Scenario Outline: User should be clone a board
    Given I navigate to Dashboard page
      And I create a new board with the following details: Board Name: "<Board Name>", description: "<Board Description>", template: "<Board Template>"
    When I cloned the board "<Board Name>"
    Then the cloned board "<Board Name>" should be displayed in the Dashboard section
      And the cloned board structure should be the same that original board
  Examples:
    |Board Name            |Board Description   |Board Template   |
    |BoardSimpleBasic      |This a test Board   |simple basic     |
#
#  @renameBoard
#  Scenario Outline: User should be able rename a Board
#    Given I navigate to Dashboard page
#      And I create a new board with the following details: Board Name: "<Board Name>", description: "<Board Description>", template: "<Board Template>"
#    When I rename the Board "<Board Name>"
#    Then I should view the Board name "<NewBoard Name>" in the boards list
##    Then the new name board "<NewBoard Name>" should be display on the Dashboard section
#  Examples:
#    |Board Name            |Board Description   |Board Template   |NewBoard Name         |
#    |BoardSimpleBasic      |This a test Board   |simple basic     |NewBoardSimpleBasic   |
#
#
#
#
#
#
#
#
##  @reorderItems
##  Scenario: As account admin, you can reorder items to suit your needs
##    Given I have four boards on the Dasboard
##    When I want to reorder boards items
##    Then I have to select Reorder items
##      And I have to move from top to bottom the items
##
##
##    When I reorder the items
##    Then the Boards list should be same reorders
##
#  @share
#    Scenario select people to board
#      Given  I have board create
#        And I have "num_people" added in the board
#      When I want to shared the board with people
#      Then I have to select member to the people list
#        And I have to assign permission level to every people selected
#        And I have to save changes
#      When I shared the board with peoples
#      Then the message "name board" board is now shared with "numPeople" people should be display in the window
#      And