Feature: OpenBar News and ToDo
		

#Scenario for News Link
Scenario: I clicked the View All News Link
		Given I clicked on View All News Link "/apex/CBI_newsPage"
		When I wait for browser for 20 seconds
		Then I should be landed on News Page "/html/body/div[1]/form/span/div/div/div[1]/div/h2"
		

#Scenario for TODO Links
Scenario: I clicked on View All TODO Link
		Given I am on OpenBar HomePage "navbar-brand"
		And I wait for another 20 seconds
		When I clicked on TODO Link
		And I wait for 10 seconds for page to load
		Then I should be landed on TODO Page "/html/body/div[1]/form/div[3]/div/div[2]/div/h2" with heading "TO DOs"			
		


#Scenario for Search - I
Scenario: I Search for Blank Template : Terms of Use
		Given I Type "Terms Of Use" in OpenBar search "srch-term"
		When I click on Search button "search-btn"
		And I wait for search results for 10 seconds
		Then I should get the "TERMS OF USE" in Search Reults "/apex/CBI_Blank_Template"

#Scenario for Search - II
Scenario: I search for Sub Category : Beer Finance
		Given I Type "Beer Finance" in OpenBar search "srch-term"
		When I click on Search button "search-btn"
		And I wait for search results for 10 seconds
		Then I should get the "Beer Finance" in Search Reults "/apex/CBI_SubCategory"

#Scenario for Search - III
Scenario: I search for  Content: Forms
		Given I Type "Forms" in OpenBar search "srch-term"
		When I click on Search button "search-btn"
		And I wait for search results for 10 seconds
		Then I should get the "Forms" in Search Reults "/apex/CBI_SubCategory"
				

#Scenario for Employee Search - I
Scenario: I search for Employee in the OpenBar Employee Directory
		Given I click on Employee Directory link "/apex/CBI_Employee_Directory"
		And I waited for Employee Directory Page to load for 5 seconds
		When I type "Mike" in FirstName TextBox "firstName"  	
		And I type "Dabisch" in LastName TextBox "LastName"
		And I click Search "SearchBtn"
		And I waited for 10 seconds
		Then I should see "Mike Dabisch" in Search Results "employee"
		
#Scenario for Employee Search - II
Scenario: I search for Employee that doesnt exist 
		Given I click on Employee Directory link "/apex/CBI_Employee_Directory"
		And I waited for Employee Directory Page to load for 5 seconds
		When I type "Test" in FirstName TextBox "firstName"  	
		And I type "Test" in LastName TextBox "LastName"
		And I click Search "SearchBtn"
		And I waited for 10 seconds
		Then I should see "No matches were found, please search again" in Search Results "noResult" 
		Then I close the browser	
		
	