package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaylocityBenefitsDashbordPage {
	
	@FindBy(id = "add") 
	private WebElement addEmployeeButton;
	
	@FindBy(id = "firstName") 
	private WebElement firstName;
	
	@FindBy(id = "lastName") 
	private WebElement lastName;
	
	@FindBy(id = "dependants") 
	private WebElement dependents;
	
	@FindBy(css = "button[id=addEmployee]") 
	private WebElement addButton;
	
	@FindBy(xpath = "//a[contains(text(),'Benefits Dashboard')]") 
	private WebElement title;
	
	@FindBy(xpath = "//h5[contains(text(),'Add Employee')]") 
	private WebElement addEmployeeFormTitle;
	
	@FindBy(xpath = "//div[@class='container']//tr") 
	private List<WebElement> tableElements;
	
	@FindBy(xpath = "//div[@class='container']//td") 
	private List<WebElement> columnElements;
	
	@FindBy(xpath = "//i[@class='fas fa-edit']")
	private WebElement editButton;
	
	
	@FindBy(id = "updateEmployee")
	private WebElement updateButton;
	
	@FindBy(xpath = "(//button[contains(text(),'Cancel')])[1]")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//i[@class='fas fa-times']")
	private WebElement deleteIcon;
	
	@FindBy(css = "button[id=deleteEmployee]")
	private WebElement deleteButton;
	
	@FindBy(xpath = "(//button[contains(text(),'Cancel')])[2]")
	private WebElement deletePageCancelButton;
	
	@FindBy(css = "span[id=deleteLastName]")
	private WebElement lastNameToBeDeleted;
		
	@FindBy(css = "span[id=deleteFirstName]")
	private WebElement firstNameToBeDeleted;
	
	@FindBy(xpath = "//h5[contains(text(),'Delete Employee')]")
	private WebElement deleteEmployeeTitle;
	
	@FindBy(xpath = "//td[contains(text(), 'No employees found.')]")
	private WebElement noEmployeeFoundElement;
	

	public WebElement getNoEmployeeFoundElement() {
		return noEmployeeFoundElement;
	}

	public WebElement getDeleteIcon() {
		return deleteIcon;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getDeletePageCancelButton() {
		return deletePageCancelButton;
	}

	public WebElement getLastNameToBeDeleted() {
		return lastNameToBeDeleted;
	}

	public WebElement getFirstNameToBeDeleted() {
		return firstNameToBeDeleted;
	}

	public WebElement getDeleteEmployeeTitle() {
		return deleteEmployeeTitle;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public List<WebElement> getColumnElements() {
		return columnElements;
	}

	public List<WebElement> getTableElements() {
		return tableElements;
	}

	public WebElement getAddEmployeeFormTitle() {
		return addEmployeeFormTitle;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getAddEmployeeButton() {
		return addEmployeeButton;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getDependents() {
		return dependents;
	}


	public WebElement getAddButton() {
		return addButton;
	} 
	
	

}
