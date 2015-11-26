
@addNewPerson
Feature: people
  Background:
    Given I navigate to Login page
    When I login as "Damian.Villanueva@fundacion-jala.org" with password "Control123"

#  Scenario Outline: :User should be able add new person in the account
#    Given I navigate to User page
#    When I added a person with the following details "<Name>", "<Email>", "<Privilege>"
#    Then the person "<Name>" added should de displayed on the page
#    And A successful message: "<Message>" should be displayed on the window
#
#  Examples:
#
#    |Name       |Email                                |Privilege              |Message      |
#    |DamianVP   |Damian.Villanueva@fundacion-jal.org  |Project manager        |New user account has been created and activated\n+ Add another one|
#    |Damian2    |penieldvp18@gmail.com                |Account administrator  |
#    |Damian3    |pvp1624@hotmail.com                  |Account owner          |
#    |Damian4    |pvp1624@hotmail.com                  |None                   |




#
#  @InviteWholeTeam

#  Scenario Outline: User should be able to invite a whole team
#    Given I navigate to User page
#    When I invite a whole team with the following details "<Name>", "<InitialName>", "<Email>"
#    Given I am in the People section
#    When I want to invite a whole team
#    Then I select Invite a whole team
#    And I enter one person per line on the text area  with the next format: John Smith, JS, john.smith@companyemail.com
#    And I select Go
#    When I invite a  whole team
#    Then a message [quantity user] users imported successfully should displayed on the window
#    And the new persons added should displayed on the people section
#
#  Examples:
#
#  |Name       |Email                                |Privilege              |
#  |Damian     |Damian.Villanueva@fundacion-jal.org  |Project manager        |
#  |Damian2    |penieldvp18@gmail.com                |Account administrator  |
#  |Damian3    |pvp1624@hotmail.com                  |Account owner          |
#  |Damian4    |pvp1624@hotmail.com                  |None                   |
#
#
#
#  @SuspendedUsers
#
#  Scenario Outline: User should be able suspend users
#    Given I navigate to User page
#    And I added a person with the following details "<User Name>", "<Email>", "<Privilege>"
#    When I suspend to user "<User Name>"
#    Then The message "<Message>" should be displayed on the window
##      And I should not able to view to suspended user "<User Name>" on the Users list
#      And I should be able view the user suspended "<User Name>" on the suspended user list
#  Examples:
#
#    |User Name  |Email                    |Privilege         |Message                  |
#    |Damian4    |pvp1624@hotmail.com      |None              |Selected user has been suspended and will not be able to login.|



#@VerifySuspendedUser
#Scenario Outline: User should be able suspend users
#  Given I navigate to User page
#    And I should be able view the user suspended "<User Name>" on the suspended user list
#  Examples:
#
#    |User Name  |Email                    |Privilege         |Message                  |
#    |Damian4    |pvp1624@hotmail.com      |None              |Selected user has been suspended and will not be able to login.|
#

#
#  @reactivateUser
#
#  Scenario Outline: User should be able reactivate users
#    Given I navigate to User page
#    And I suspend to user "<User Name>"
#    And I navigate to Suspended User List
#    When I reactive to user "<User Name>"
#    Then I should be able to view the message: There are no suspended users
#    And I should be able to view to reactive user on Users lis
#  Examples:
#    |User Name          |
#    |Damian4            |
#    |Damian Villanueva  |
#    |Peniel Villanueva  |


#
  @deleteUser

  Scenario Outline: User should be able to delete a User
    Given I navigate to User page
      And I added a person with the following details "<User Name>", "<Email>", "<Privilege>"
      And I suspend to user "<User Name>"
      And I have 3 suspended users
      And I enter to suspended user list
    When I delete to user "<User Name>"
    Then I should not be able to view to delete user on the Suspender User List
      And I should not be able to view to delete user on the User List
  Examples:

    |User Name  |Email                    |Privilege         |Message                  |
    |Damian4    |pvp1624@hotmail.com      |None              |Selected user has been suspended and will not be able to login.|


#    |Damian Villanueva  |
#    |Peniel Villanueva  |
#
#  @editUser

#  Scenario edit a user
#    Given I have three user added on the active user list
#    When I want to edit a user
#    Then I have to select Edit to a user
#    And I have to change any field
#    And I have to select update user details
#    When I edit a  user
#    Then the changes should be display to the user on the active user list
#
#  Scenario Outline: User should be able to edit a User
#    Given I navigate to Users page
#      And I have 3 users added
#    When I Edit the user "<User Name>"
#    Then I should be able to view the changes on the active user list
#  Examples:
#    |User Name          |
#    |Peniel Damian      |
#    |Damian Villanueva  |
#    |Peniel Villanueva  |