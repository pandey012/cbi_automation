
@TODO
Feature: Test OpenBar ToDo's

Scenario: Click on OpenBar ToDo's Link
	Given I am on OpenBar Home Page "navbar-brand"
	When I clicked on View All ToDo Link "/apex/CBI_todo"
	Then I should land on ToDo Page
	