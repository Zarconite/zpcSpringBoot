Feature: Adding a new part
As a Manager
I want to be able to add a new part to the website
So that customers can buy new products

Scenario Outline: 
   Given I log into an admin account
   When I navigate to the add a part form
   And I click the part "<type>" type dropdown menu
   And I fill out the "<brand>" brand
   And I fill out the "<model>" model
   And I fill out the "<name>" name
   And I fill out the "<outputs>" outputs
   And I fill out the "<inputs>" inputs
   And I fill out if the part is "<overclockable>" overclockable
   And I fill out the "<extra>" extra information
   And I fill out the "<baseclock>" base clock
   And I fill out the "<boostclock>" boost clock
   And I fill out the "<price>" price
   And I fill out the "<wattage>" name
   And I fill out the "<stock>" count
   Then the new part will be added to the database
   
Examples:
    | type  | brand | model | name | outputs | inputs | overclockable | extra | baseclock | boostclock | price | wattage | stock |
    | Cpu  | AMD | Ryzen 5 | 2400G |  | AM4 | 1 | 4 Cores, 8 Threads | 3.4GHz | 3.7GHz | 89.99 | 65 | 10 |
    | Gpu  | AMD | Radeon Vii | Reference |  | PCIE16x | 1 | 3840 Cores | 1400MHz | 1750MHz | 749.99 | 295 | 2 |
    | Ram  | Corsair | DDR4 | 32GB Vengeance |  | DDR4 | 0 |  | 3200MHz |  | 199.99 | 5 | 5 |
    
