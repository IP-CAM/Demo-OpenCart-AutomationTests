Feature: Viewing the products
  Scenario: User can view products
    Given User is at the home page
    When User clicks on the featured item
    Then the details of the product is opened

    Given user searches for product via search bar
    When user successfully finds the product and clicks on it
    Then the details of the searched product is opened