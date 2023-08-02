Feature: Apply Feature
  Background:
    Given the user should go to testlio page
    Then the user should validate the correct page

    @wip
    Scenario: Full-time work at Testlio
      Given the user should go to the "Work" module
      When the user should go to the "Full-Time" secondary module
      Then the user should see "Full-time work at Testlio" text
     # And the user should go to the See open positions page
      And the user should choose "Software QA Analyst" page
      And the user should choose Apply now text
      And the user should fill out the form "Olcay", "Er", "olcayer25@gmail.com", "05056184240"
      And the user should add Resume and Cover Letter
      And the user should fill out the related areas "linkedin.com/in/olcay-er", "QA", "2", "Turkey", "$30 USD/hr"
      And the user should select the multiplechoice questions' answers
      And the user click submit button
      And the user should validate "Thank you for your interest!" the message