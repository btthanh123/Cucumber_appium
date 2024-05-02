Feature: Testcase01

  Background:
    Given I am on General Store app

  @Test01
  Scenario: Book 2 items from General Store app
    When I login in General Store app with country "Argentina" and name "Maria"
    And I want to add "2" items in the card
    And I go to Cart page
    Then I verify the order with information displayed as the table below
      | Number item | Total Amount |
      | 2           | 280.97       |