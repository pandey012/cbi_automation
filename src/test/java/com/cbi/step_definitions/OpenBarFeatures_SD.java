package com.cbi.step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cbi.helper.WebDriverConfig;
import cucumber.api.java8.En;


public class OpenBarFeatures_SD implements En {
	
	WebDriver driver = null;
	
	public OpenBarFeatures_SD()
	{
		
		
		Given("^I clicked on View All News Link \"([^\"]*)\"$", (String arg1) -> {
			
			driver = WebDriverConfig.getIE();
			//driver = WebDriverConfig.getLocalFirefox();
			driver.findElement(By.cssSelector("a[href*='"+arg1+"']")).click();
		});
		
		When("^I wait for browser for (\\d+) seconds$", (Integer arg1) -> {
			driver.manage().timeouts().implicitlyWait(arg1, TimeUnit.SECONDS);
		});

		
		Then("^I should be landed on News Page \"([^\"]*)\"$", (String arg1) -> {	
			String newsLabel = "/html/body/div[1]/form/span/div/div/div[1]/div/h2";
			assertEquals(driver.findElement(By.className("row page-header").className("col-sm-9").cssSelector("h2")).getText(),"NEWS" );
		});
		
		
		
		Given("^I am on OpenBar HomePage \"([^\"]*)\"$", (String arg1) -> {
			driver = WebDriverConfig.getIE();
			driver.findElement(By.className(arg1)).click();
			//driver.get(arg1);
		});
		
		Given("^I wait for another (\\d+) seconds$", (Integer arg1) -> {
			driver.manage().timeouts().implicitlyWait(arg1, TimeUnit.SECONDS);
		});

		When("^I clicked on TODO Link$", () -> {
			driver.findElement(By.cssSelector("a[href*='/apex/CBI_todo']")).click();
		});
		
		When("^I wait for (\\d+) seconds for page to load$", (Integer arg1) -> {
			driver.manage().timeouts().implicitlyWait(arg1, TimeUnit.SECONDS);
		});

		Then("^I should be landed on TODO Page \"([^\"]*)\" with heading \"([^\"]*)\"$", (String arg1, String arg2) -> {
			
			assertEquals(driver.findElement(By.className("row page-header").className("col-sm-9")).getText(), arg2 );
		});
		
		
		Given("^I Type \"([^\"]*)\" in OpenBar search \"([^\"]*)\"$", (String searchTerm, String searchBoxId) -> {
			driver = WebDriverConfig.getIE();
			driver.findElement(By.id(searchBoxId)).sendKeys(searchTerm);
		});

		When("^I click on Search button \"([^\"]*)\"$", (String buttonClass) -> {
			driver.findElement(By.className(buttonClass)).click();
		});

		When("^I wait for search results for (\\d+) seconds$", (Integer seconds) -> {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		});

		Then("^I should get the \"([^\"]*)\" in Search Reults$", (String expectedValue) -> {
			String termsOfUse = driver.findElement(By.cssSelector("a[href*='/apex/CBI_Blank_Template']")).getText();
			assertEquals(termsOfUse,expectedValue );
		});

		

		Then("^I close the browser$", () -> {
			driver.quit();
			
		});


	}
	
	
}
