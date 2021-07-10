Feature: Searching products
  Scenario: User can successfully search for products
    Given User is at the web shop
    When User enters product name in the search bar
    And Users press enter or search button
    Then Results of the search are shown