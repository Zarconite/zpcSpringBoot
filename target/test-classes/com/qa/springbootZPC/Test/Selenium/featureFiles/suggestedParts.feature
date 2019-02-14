Feature: Suggested Parts
As a content creator
I want the website to be able to suggest parts for me
So that I can build an ideal pc that's fit for purpose
and to ensure that it's all compatible

Scenario:
	Given I navigate to the pc builder
	When I select automatic
	And I input my max price
	And I select Balanced performance
	And I click accept
	Then I should be presented with a fully compatible build below my max price
