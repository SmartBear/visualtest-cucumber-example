Feature: Search for products

  Scenario: Search for an item with a single result
    Given a visitor has opened the homepage
    When a visitor searches for "Sports"
    Then there should be 2 results
