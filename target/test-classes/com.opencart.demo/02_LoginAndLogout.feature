Feature: Login and logout
  Scenario: User can login and logout with his/her created account
    Given User is at login page
    When User enters username and password
    And Clicks on login button
    Then User should be logged in

    Given User is at My Account page
    When User clicks on logout button
    Then User should be logged out
