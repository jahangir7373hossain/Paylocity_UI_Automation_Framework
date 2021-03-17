
Feature: Paylocity Benefits Dashboard
	
	Scenario: Add Employee
		Given an Employer
		And I am on the Benefits Dashboard page
		When I select Add Employee
		Then I should be able to enter employee details
		And the employee should save
		And I should see the employee in the table
		And the benefit cost calculations are correct
		And close the browser
	
	Scenario: Edit Employee
		Given an Employer
		And I am on the Benefits Dashboard page
		When I select the Action Edit
		Then I can edit employee details
		And the data should change in the table
		And close the browser
		
	Scenario: Delete Employee
		Given an Employer
		And I am on the Benefits Dashboard page
		When I click the Action X
		Then the employee should be deleted
		And close the browser