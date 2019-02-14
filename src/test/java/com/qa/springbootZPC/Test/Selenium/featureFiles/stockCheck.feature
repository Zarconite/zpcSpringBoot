Feature: Check the stock of a part
As a Customer
I want to be able to check if a product is in stock
So that I can choose another product instead of waiting

Scenario: 
   Given I navigate to the parts list
   When I view a product
   Then I should be able to see if the part is in stock or not