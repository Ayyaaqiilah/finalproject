@api
Feature: API Testing for DummyAPI User

  Scenario: Get user by ID
    Given I send a request to get user by id "60d0fe4f5311236168a109d4"
    Then the response status code should be 200

  Scenario: Create a new user
    Given I create a new user with firstName "John", lastName "Doe", and email "unique"
    Then the response status code should be 200
