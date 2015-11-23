Feature: OpenBar News and ToDo

Scenario: I clicked the View All News Link
		Given I clicked on View All News Link "/html/body/div[1]/form/div[4]/div/div/section[1]/h3/a"
		When I wait for browser for 20 seconds
		Then I should be landed on News Page "/html/body/div[1]/form/span/div/div/div[1]/div/h2"
		

Scenario: I clicked on View All TODO Link
		Given I am on OpenBar HomePage "navbar-brand"
		And I wait for another 20 seconds
		When I clicked on TODO Link
		And I wait for 10 seconds for page to load
		Then I should be landed on TODO Page "/html/body/div[1]/form/div[3]/div/div[2]/div/h2" with heading "TO DOs"			
		And I close the browser	