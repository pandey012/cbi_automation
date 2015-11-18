Feature: OpenBar Login

Scenario: I login with valid credentials
		Given I use Chrome Browser
		Given I navigate to "https://cbrands--edgeforce--c.cs17.visual.force.com/apex/CBI_Home?sfdc.tabName=01rG0000000fTpR"
		And I wait for 10 seconds
		And I enter "himanshu.pandey@cbrands.com.ta" into the field with id "username"
		And I enter "TestAdmin123" as Password into the field with id "password"
		When I click on the element with id "Login"
		And I wait for 20 seconds
		Then I should be loggedIn
		Then I close the browser