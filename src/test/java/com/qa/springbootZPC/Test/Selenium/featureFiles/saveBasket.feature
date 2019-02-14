Feature: Saving a Basket
As a Customer
I want to be able to save my basket
and the basket to show the total price of everything
So that I can purchase it at a later date

Scenario Outline: 
   Given I click on the search bar
   When I search for a part "<name>"
   And add it to the basket
   And I search for another part "<name2>"
   And I add that part to the basket
   Then I the basket should display both parts
   And show the correct price
   
Examples:
    | name | name2 |
    | 1080 | 2600x |
    | 9900k | primera |
    | Pentium | freezer |
