package com.cbi.step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cbi.helper.SharedDriver;
import com.cbi.helper.WebDriverConfig;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.picocontainer.*;


public class OpenBarFeatures_SD  {
	
	
	/* private WebDriverConfig webDriverConfig;

	   // PicoContainer injects class ContextSteps
	   public OpenBarFeatures_SD (WebDriverConfig webDriverConfig) {
	      this.webDriverConfig = webDriverConfig;
	      driver= webDriverConfig.getDriver();
	   }
*/
	WebDriver driver;
	public OpenBarFeatures_SD(WebDriverConfig driver)
	{
		//this.login = login;
		this.driver = driver.getDriver();
		

	}
	
	@Given("^I Navigate to News Page \"([^\"]*)\"$")
	public void i_Navigate_to_News_Page(String arg1) throws Throwable {
		
	    driver.get(arg1);
	    driver.switchTo().defaultContent();
	}
	
	@When("^I wait for browser for (\\d+) seconds$")
	public void i_wait_for_browser_for_seconds(int arg1) throws Throwable {
		driver.manage().timeouts().implicitlyWait(arg1, TimeUnit.SECONDS);
	}

	@Then("^I should be landed on News Page \"([^\"]*)\"$")
	public void i_should_be_landed_on_News_Page(String arg1) throws Throwable {
		String newsLabel = "/html/body/div[1]/form/span/div/div/div[1]/div/h2";
		assertEquals(driver.findElement(By.className("row page-header").className("col-sm-9").cssSelector("h2")).getText(),"NEWS" );
		//driver.quit();
	}
	
	
	
	
}
