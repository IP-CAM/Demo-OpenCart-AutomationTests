Feature: Wish list
  Scenario: User can wish list products and remove products from the wish list
    Given User is logged in
    And User is at product details page
    When User clicks on heart icon
    Then The item is added to the wish list

    Given User is logged in
    When User clicks on Wish List button in the header
    And Clicks on the X button at the item
    Then The product is removed from the wish list
