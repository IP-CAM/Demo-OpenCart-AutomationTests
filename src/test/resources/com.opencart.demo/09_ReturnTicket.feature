Feature: Return Ticket
  Scenario: User can fill a return ticket
    Given User is logged in and has placed order
    When User goes to order history
    And Opens order that he or she wants to return
    And Clicks on return button
    And Select a reason for return
    And Clicks on submit button
    Then Return request is created