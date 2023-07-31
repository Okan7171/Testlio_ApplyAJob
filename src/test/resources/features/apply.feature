Feature: Apply Feature
  Background:
    Given the user should go to testlio page
    Then the user should validate the correct page

    @wip
    Scenario: Full-time work at Testlio
      Given the user should go to the "Work" module
      When the user should go to the "Full-Time" secondary module
      Then the user should see "Full-time work at Testlio" text
