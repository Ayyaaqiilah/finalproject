@web
Feature: Login functionality in SauceDemo

  Scenario: Login with valid credentials
    Given I open Saucedemo login page
    When I login with username "standard_user" and password "secret_sauce"
    Then I should see the products page
