@Footer

Feature: Test for Openbar Footer Notes

Scenario: I Test for the Footer Notes
	Given I clicked on the OpenBar Logo "navbar-brand" with href "/apex/CBI_Home"
	When I looked for the footer notes 
	Then Year in copyright "copyright" should be the current Year
	
	
	

