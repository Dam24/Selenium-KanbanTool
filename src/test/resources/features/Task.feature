@addTask
Feature task

  Scenario: add a task on the board
    Given I have a board created
    When i want tio add a new task
    Then I have to select add task on the "column name"
      And I have to  write "nameTask", "description", "card type", "priority", "estimated", "Difficulty"
    When I added a new task
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
      Given I have a board created
      And I have a Task added on the board
      When I want to edit a Task
      Then I have to entry to properties task
      Or I have to select Edit by right click on the task
        And I should be modify the "name" and "description"
      When I edit a task
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
          Given I have a board created
          And I have a Task added on the board
          When I want to delete a task
          Then I have to select Delete by right click on a task
          When I delete a task
          Then the task deleted not should display on the column "column name" on the board


  @assignTask
          Feature task
          Scenario assign a task
            Given I have a board created
            And I have a Task added on the board
            When I want to assign a task to team member
            Then I have to assign to a team member by click rigth on a task
            When I assign a task to team member
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