@site
Feature: operation site
Background:
  login with user "" with password ""

Scenario Outline 1:	Add a new site
  Given I have a valid account on weebly
  When I want to add a new site
  Then I have that enter to My Sites window
  Then I add a new site
  And I choose a new theme
  And I register a valid site domain

  And I enter the required information "xx,xy,yy,...,"

Examples:
|value|
|value1|


Scenario 2:	Delete a site
  Given a valid account on Weebly
  When I want to delete a site
  Then I have to enter on a selected site
  And I have to press Delete a site
  And I have to confirm delete the site

Scenario 3:	Edit a site
  Given a valid account on Weebly
  When I want to delete a site
  Then I have to enter on a selected site
  And I have to press Edit site
  And I have to confirm delete the site
