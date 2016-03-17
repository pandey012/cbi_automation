package com.cbi.step_definitions;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.cbi.helper.WebDriverConfig;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpenBarOtherSteps {
	
	
	WebDriver driver;
	public OpenBarOtherSteps(WebDriverConfig driver)
	{
		this.driver = driver.getDriver();
	}
	
	
	@Given("^I clicked on the OpenBar Logo \"([^\"]*)\" with href \"([^\"]*)\"$")
	public void i_clicked_on_the_OpenBar_Logo_with_href(String className, String arg2) throws Throwable {
		driver.findElement(By.className(className)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^I looked for the footer notes$")
	public void i_looked_for_the_footer_notes() throws Throwable {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1650)", "");
	}


	@Then("^Year in copyright \"([^\"]*)\" should be the current Year$")
	public void year_in_copyright_should_be_the_current_Year(String className) throws Throwable {
		
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		String copyright = driver.findElement(By.className(className)).getText();
		assert(copyright.contains(String.valueOf(currentYear)));
	}

}
