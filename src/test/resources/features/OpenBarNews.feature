Feature: OpenBar News

Scenario: I clicked the View All News Link
		Given I clicked on View All News Link "/html/body/div[1]/form/div[4]/div/div/section[1]/h3/a"
		When I wait for browser for 5 seconds
		Then I should be landed on News Page "/html/body/div[1]/form/span/div/div/div[1]/div/h2/span"
		And I close the browser
				