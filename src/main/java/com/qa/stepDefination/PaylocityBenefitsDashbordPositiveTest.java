package com.qa.stepDefination;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utils.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PaylocityBenefitsDashbordPositiveTest extends TestBase {

	private String firstName;
	private String lastName;
	private String dependent;

	@Given("an Employer")
	public void an_Employer() {
		setUp();
	}

	@Given("I am on the Benefits Dashboard page")
	public void i_am_on_the_Benefits_Dashboard_page() throws InterruptedException {
		String titleText = paylocityBenefitsDashbordPage.getTitle().getText();
		Assert.assertEquals("Paylocity Benefits Dashboard", titleText);
	}

	@When("I select Add Employee")
	public void i_select_Add_Employee() throws InterruptedException {		
		String addEmlpButton = paylocityBenefitsDashbordPage.getAddEmployeeButton().getText();
		Assert.assertEquals("Add Employee", addEmlpButton);
		paylocityBenefitsDashbordPage.getAddEmployeeButton().click();
	}

	@Then("I should be able to enter employee details")
	public void i_should_be_able_to_enter_employee_details() {
		// Verify if add employee title is correct
		Assert.assertEquals("Add Employee", paylocityBenefitsDashbordPage.getAddEmployeeFormTitle().getText());

		// Fill out the form
		paylocityBenefitsDashbordPage.getFirstName().clear();
		firstName = randomFirstNameGenerator();
		paylocityBenefitsDashbordPage.getFirstName().sendKeys(firstName);

		paylocityBenefitsDashbordPage.getLastName().clear();
		lastName = randomLastNameGenerator();
		paylocityBenefitsDashbordPage.getLastName().sendKeys(lastName);

		paylocityBenefitsDashbordPage.getDependents().clear();
		dependent = randomNumberGenerator();
		paylocityBenefitsDashbordPage.getDependents().sendKeys(dependent);

	}

	@Then("the employee should save")
	public void the_employee_should_save() {
		// verify the add button
		Assert.assertEquals("Add", paylocityBenefitsDashbordPage.getAddButton().getText());
		paylocityBenefitsDashbordPage.getAddButton().click();
		
	}

	@Then("I should see the employee in the table")
	public void i_should_see_the_employee_in_the_table() throws InterruptedException {

		Assert.assertTrue(paylocityBenefitsDashbordPage.getTableElements().size() > 0);

		// Here without thread.sleep it does not work with explicitly wait
		Thread.sleep(2000);

		// WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait.until(ExpectedConditions.visibilityOfAllElements(paylocityBenefitsDashbordPage.getColumnElements()));

		// verify added employee first name
		Assert.assertEquals(firstName, paylocityBenefitsDashbordPage.getColumnElements().get(1).getText());

		// verify added employee last name
		Assert.assertEquals(lastName, paylocityBenefitsDashbordPage.getColumnElements().get(2).getText());
	}

	@Then("the benefit cost calculations are correct")
	public void the_benefit_cost_calculations_are_correct() {

		// Checking Benefits cost
		Assert.assertEquals(benefitsCostCalculation(dependent),
				paylocityBenefitsDashbordPage.getColumnElements().get(6).getText());

		// checking net pay
		Assert.assertEquals(netPay(dependent), paylocityBenefitsDashbordPage.getColumnElements().get(7).getText());

	}

	// Edit employee

	@When("I select the Action Edit")
	public void i_select_the_Action_Edit() throws InterruptedException {
		paylocityBenefitsDashbordPage.getEditButton().click();
		// I am not able to verify the update employee form because of a bug. The title
		// is Add employee instead of update employee
	}

	@Then("I can edit employee details")
	public void i_can_edit_employee_details() throws InterruptedException {

		// Fill out the form to update
		// Here i am using same function that i created for add employee
		// Every time when this function execute. It will generate random data for first
		// name, Last name and dependents
		i_should_be_able_to_enter_employee_details();

		Assert.assertEquals("Update", paylocityBenefitsDashbordPage.getUpdateButton().getText());
		Assert.assertEquals("Cancel", paylocityBenefitsDashbordPage.getCancelButton().getText());

		paylocityBenefitsDashbordPage.getUpdateButton().click();
	}

	@Then("the data should change in the table")
	public void the_data_should_change_in_the_table() throws Exception {

		// After updating the data this function will check if the data replicate
		// correctly in the table.
		// Here function is reused
		i_should_see_the_employee_in_the_table();
	}

	@When("I click the Action X")
	public void i_click_the_Action_X() {
		paylocityBenefitsDashbordPage.getDeleteIcon().click();

		// Verify title, name to be deleted, delete button and cancel button
		Assert.assertEquals("Delete Employee", paylocityBenefitsDashbordPage.getDeleteEmployeeTitle().getText());

		// Here first fetching the first name and last name from the table then
		// comparing with data we get after click on delete button
		Assert.assertEquals(paylocityBenefitsDashbordPage.getColumnElements().get(1).getText(),
				paylocityBenefitsDashbordPage.getFirstNameToBeDeleted().getText());
		Assert.assertEquals(paylocityBenefitsDashbordPage.getColumnElements().get(2).getText(),
				paylocityBenefitsDashbordPage.getLastNameToBeDeleted().getText());

		Assert.assertEquals("Delete", paylocityBenefitsDashbordPage.getDeleteButton().getText());
		Assert.assertEquals("Cancel", paylocityBenefitsDashbordPage.getDeletePageCancelButton().getText());

		// deleting the employee
		paylocityBenefitsDashbordPage.getDeleteButton().click();

	}

	@Then("the employee should be deleted")
	public void the_employee_should_be_deleted() {
		Assert.assertEquals("No employees found.", paylocityBenefitsDashbordPage.getNoEmployeeFoundElement().getText());
	}

	@Then("close the browser")
	public void close_the_browser() {
		classTearDown();
	}
}
