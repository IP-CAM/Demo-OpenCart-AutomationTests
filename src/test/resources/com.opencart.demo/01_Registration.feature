Feature: Registration
  Scenario Outline: User can successfully register with valid data
    Given user is at register page
    When user enters valid <firstName>, <lastName>, email, <telephone> and password
    And choose if he wants to accept newsletter
    And agree with privacy policy
    And clicks on continue button
    Then user should see the success message
    Examples:
      |firstName|lastName|telephone|
      |"John"   |"Doe"   |"0000000"|
