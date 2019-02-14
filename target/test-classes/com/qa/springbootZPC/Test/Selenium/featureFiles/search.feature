Feature: Searching for parts
As a Customer
I want to be able to search for a particular part
So that I don't have to manually find the part I'm looking for

Scenario Outline: 
   Given I click on the search bar
   When I type in a part name "<name>"
   Then I should only see relevant search results
   
Examples:
    | name  |
    | 1080 |
    | Xfx |
    | Pentium |
    | Ryzen |
    | Silverstone |
