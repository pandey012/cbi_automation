Feature: OpenBar News and ToDo

Scenario: I clicked the View All News Link
		Given I clicked on View All News Link "/html/body/div[1]/form/div[4]/div/div/section[1]/h3/a"
		When I wait for browser for 5 seconds
		Then I should be landed on News Page "/html/body/div[1]/form/span/div/div/div[1]/div/h2/span"
		

Scenario: I clicked on View All TODO Link
		Given I am on OpenBar HomePage "https://cbrands--edgeforce--c.cs17.visual.force.com/apex/CBI_Home?sfdc.tabName=01rG0000000fTpR"
		And I wait for another 10 seconds
		When I clicked on TODO Link "/html/body/div[1]/form/div[4]/div/div/section[2]/h3/a"
		And I wait for another 10 seconds
		Then I should be landed on TODO Page "//*[@id='main-content']/div[2]/div/h2" 				
		And I close the browser		