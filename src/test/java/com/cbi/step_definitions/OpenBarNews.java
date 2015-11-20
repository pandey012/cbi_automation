package com.cbi.step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cbi.helper.WebDriverConfig;
import cucumber.api.java8.En;


public class OpenBarNews implements En {
	
	WebDriver driver = null;
	
	public OpenBarNews()
	{
		
		Given("^I clicked on View All News Link \"([^\"]*)\"$", (String arg1) -> {
			
			driver = WebDriverConfig.getIE();
			driver.findElement(By.xpath(arg1)).click();
		});
		
		When("^I wait for browser for (\\d+) seconds$", (Integer arg1) -> {
			driver.manage().timeouts().implicitlyWait(arg1, TimeUnit.SECONDS);
		});

		
		Then("^I should be landed on News Page \"([^\"]*)\"$", (String arg1) -> {			
			assertEquals(driver.findElement(By.xpath(arg1)).getText(),"NEWS" );
		});
		
		Then("^I close the browser$", () -> {
		   driver.quit();
		});

	}
	
}
