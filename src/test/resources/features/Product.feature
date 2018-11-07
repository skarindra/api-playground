Feature: Product

  Scenario: Get All Products
    Given the user wants to get all products
    Then verify one example product

  Scenario Outline: Get Product By ID
    Given the user wants to get product by id "<id>"
    Then verify product by "<id>"

    Examples:
    |id|
    |43900|

  Scenario Outline: Create New Product
    Given the user wants to create new product with "<name>" "<type>" "<price>" "<upc>" "<description>" "<model>"
    Then product will be created with "<name>" "<type>" "<price>" "<upc>" "<description>" "<model>"

    Examples:
    |name|type|price|upc|description|model|
    |Test Product Name|TestType|123|37283782|Test create product|TPX|