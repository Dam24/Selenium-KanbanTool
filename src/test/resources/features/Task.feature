@addTask
Feature task

  Scenario: add a task on the board
    Given I have to a board created
    And I navigate to the board created
    When I added a new task in the board with the following details: "nameTask", "description", "card type", "priority", "estimated", "Difficulty"
    Then the new task should display on the board on the "column name"



  Examples:
    |name  |description     |cardType    |priority|estimated  |Difficulty|
    |Task1 |this is a task  |yellow      |high    |           |          |
    |Task2 |this is a task  |strong_red  |normal  |           |          |
    |Task3 |this is a task  |pink        |low     |           |          |
    |Task4 |this is a task  |violet      |high    |           |          |

  @editTask
    Feature task

    Scenario edit a task
      Given I have to a board created
        And I have a Task added on the board
      When I edited the task name
        And I edited the task priority
        And I edited the card type
      Then the modify dates should display on the task on the board


  @duplicateTask
      Feature task
      Scenario duplicate a task
        Given I have a board created
        And I have a task added on the board
        When I want to duplicate a task
        Then I have to select Duplicate by right click on a task
        When I duplicate a task
        Then the duplicate task should display on the column "column name" on the board

  @deleteTask
        Feature task
        Scenario delete a task
          Given I have to a board created
          And I have to a Task added on the board
          When I delete the task
          Then the task deleted not should display on the column "column name" on the board


  @assignTask
          Feature task
          Scenario assign a task
            Given I have to a board created
              And I have to a Task added on the board
            When I assigneed a task to team member
            Then the initial name should display on the below task on the board

  @changePriority
            Feature task
            Scenario change pri
  @chance type task
  @moveTask
              Feature task
              Scenario move a task to column "column_name1" to "column_name2"
                Given I have a board created
                And I have a task added on the board
                When I want to move a task
                Then
  @move to task
  @add to  my work task
  @archiveTask
  Feature task
                Scenario archive task
                  Given I have a board created
                  And I have a task added on the board
                  When I want a archive a task
                  Then