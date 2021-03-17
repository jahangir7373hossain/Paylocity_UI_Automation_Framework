package com.qa.utils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.PageFactory;
import com.qa.pages.PaylocityBenefitsDashbordPage;

public class TestBase extends TestUtils{
	
	
	public PaylocityBenefitsDashbordPage paylocityBenefitsDashbordPage;
	
	@Before
	public void setUp() {
		driverSetUp();
		paylocityBenefitsDashbordPage = PageFactory.initElements(driver, PaylocityBenefitsDashbordPage.class);
	}
	
	@After
	public void classTearDown() {
		driver.quit();
	}

}
