Feature: Change password
  Scenario Outline: User can change password and use it for login
    Given User is on My Account page
    When User click on password
    And Enter <newPassword>, confirm it and clicks on continue
    And User tries to login with new password
    Then User can successfully login

    Examples:
      | newPassword |
      | "testpass123" |