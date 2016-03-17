package com.cbi.step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cbi.helper.WebDriverConfig;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;


public class OpenBarSearchSteps {
	
	WebDriver driver;
	public OpenBarSearchSteps(WebDriverConfig webDriver)
	{
		this.driver = webDriver.getDriver() ;
		
	}
	
	@Given("^I Type \"([^\"]*)\" in OpenBar search \"([^\"]*)\"$")
	public void i_Type_in_OpenBar_search(String searchTerm, String searchBoxId) throws Throwable {
		driver.findElement(By.className("search-pane")).findElement(By.id(searchBoxId)).clear();
		driver.findElement(By.className("search-pane")).findElement(By.id(searchBoxId)).sendKeys(searchTerm);
	}

	@When("^I click on Search button \"([^\"]*)\"$")
	public void i_click_on_Search_button(String buttonClass) throws Throwable {
		driver.findElement(By.className(buttonClass)).click();
	}

	@When("^I wait for search results for (\\d+) seconds$")
	public void i_wait_for_search_results_for_seconds(int arg1) throws Throwable {
		

		driver.manage().timeouts().implicitlyWait(arg1, TimeUnit.SECONDS);
	}

	@Then("^I should get the \"([^\"]*)\" in Search Reults \"([^\"]*)\"$")
	public void i_should_get_the_in_Search_Reults(String expectedValue, String cssSelector) throws Throwable {
		String actualResult = "";		
		 driver.findElements(By.className("searchResultItem")).clear();
		actualResult = driver.findElements(By.className("searchResultItem")).get(0).getText();
		assertEquals(expectedValue ,actualResult );
		
	}
	
	@Then("^I should get the \"([^\"]*)\" in Search Reults with link \"([^\"]*)\"$")
	public void i_should_get_the_in_Search_Reults_with_link(String expectedValue, String cssSelector) throws Throwable {

		
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("searchResultItem")));
			 driver.findElements(By.className("searchResultItem")).clear();
			String actualResult = driver.findElements(By.className("searchResultItem")).get(0).getText();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(1000);
			assertEquals(actualResult,expectedValue );
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
	}



}
