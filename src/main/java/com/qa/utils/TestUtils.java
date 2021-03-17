package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {
	
	public static WebDriver driver;
	
	
	
	
	public void driverSetUp() {		

		String browser = getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//src//main//java//exxfile//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".//src//main//java//exeFile//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(getProperty("URL"));
		
		 WebElement userName = driver.findElement(By.id("Username"));
		 WebElement password = driver.findElement(By.id("Password"));
		 WebElement submit = driver.findElement(By.xpath("//button[contains(text(),'Log In')]"));
		
		userName.clear();
		userName.sendKeys(getProperty("username"));
		password.clear();
		password.sendKeys(getProperty("password"));
		submit.click();
	}
	
	
	 private Random generate = new Random();
    
	
	
	public String randomFirstNameGenerator() {
		 String[] firstNameArr = {"John", "Marcus", "Susan", "Henry"};
		return firstNameArr[generate.nextInt(firstNameArr.length)];
	
	}
	
	public String randomLastNameGenerator() {
		String[] lastNameArr = {"Atkins", "Rojo", "Cary", "Nelson"};
		return lastNameArr[generate.nextInt(lastNameArr.length)];
	}
	
	public String randomNumberGenerator() {
		int random = (int )(Math.random() * 32 + 1); 		
		return String.valueOf(random);
	}
	
	public String benefitsCostCalculation(String dependents) {
		
		int num = Integer.valueOf(dependents);
		
		// multiply each dependent with $ 500
		double benefitsCost = (num * 500) + 1000;		
		
		return new DecimalFormat("0.00").format(benefitsCost/26);
	}
	
	public String netPay(String dependents) {
		
		double benefitsCost = Double.valueOf(benefitsCostCalculation(dependents));
		
		return new DecimalFormat("0.00").format(2000-benefitsCost);
	}

	/**
	 * Method name: getProperty
	 * 
	 * @Purpose: This method will fetch value from property file
	 * @return
	 */

	public String getProperty(String key) {
		String value = null;

		Properties prop = loadProperty("testRun");
		value = prop.getProperty(key);

		if (value == null) {
			String env = prop.getProperty("env");
			prop = loadProperty(env);
			value = prop.getProperty(key);

		}

		return value;
	}

	/*
	 * Method Name: loadProperty Purpose : This method will help to load the
	 * properties from property file
	 */

	public Properties loadProperty(String propFileName) {
		Properties prop = new Properties();

		String filePath = ".\\src\\main\\java\\com\\qa\\config\\" + propFileName + ".properties";

		try {
			File file = new File(filePath);
			FileInputStream steam = new FileInputStream(file);
			prop.load(steam);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return prop;
	}
	
	public void explicitTime(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		
	}

}
