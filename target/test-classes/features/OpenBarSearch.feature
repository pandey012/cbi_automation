
@Search
Feature: Search 


#Scenario for Search - III
#Scenario: I search for  Content: Forms
#		Given I wait for 20 seconds
#		Given I Type "Forms" in OpenBar search "srch-term"
#		When I click on Search button "search-btn"
#		And I wait for search results for 25 seconds
#		Then I should get the "Forms" in Search Reults "/apex/CBI_SubCategory"
		
		
		
Scenario Outline: I search for differnt Items in OpenBar
  	Given I Type "<searchTerm>" in OpenBar search "srch-term"
    When I click on Search button "search-btn"
    And I wait for search results for 20 seconds
  	Then I should get the "<result>" in Search Reults with link "<link>"


  
  Examples:
    | searchTerm   | result      | link     | 
    | Beer Finance | Beer Finance| /apex/CBI_SubCategory |
   # | Terms of Use | TERMS OF USE| /apex/CBI_Blank_Template | 
   
