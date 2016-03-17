@NewsFeature
Feature: OpenBar Login and News and ToDo



#Scenario for News Link
Scenario: I clicked the View All News Link
		Given I Navigate to News Page "https://cbrands--edgeforce--c.cs17.visual.force.com/apex/CBI_newsPage"
		When I wait for browser for 20 seconds
		Then I should be landed on News Page "/html/body/div[1]/form/span/div/div/div[1]/div/h2"
		
