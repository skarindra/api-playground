Feature: Product

  Background:
    Given the user wants to create new product with "Test Product Name" "TestType" "123" "37283782" "Test create product" "TPX"
    Then product will be created with "Test Product Name" "TestType" "123" "37283782" "Test create product" "TPX"

  Scenario: Delete recently created product
    Given the user wants to delete recently created product
    Then product will be deleted
