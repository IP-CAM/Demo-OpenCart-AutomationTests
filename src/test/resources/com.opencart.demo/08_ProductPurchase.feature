Feature: Product Purchase
  Scenario Outline: User can finish product purchase
    Given User added the product to the cart
    When User proceed to the checkout
    And User logs in
    And User enter <firstName>, <lastName>, <company>, <address>, <city>, <postcode>, and choose country and region, and press continue
    And choose delivery address and clicks on continue
    And select delivery method and clicks on continue
    And select payment method and accept the terms
    And confirm the order
    Then His or her order will be placed

    Examples:
      | firstName | lastName | company | address | city | postcode |
      | "John"    |"Doe "     |"Tesla"  |"Unknown 5"|"Los Angeles"| "90210"|

