package com.cbi.step_definitions;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.cbi.helper.WebDriverConfig;
import cucumber.api.java8.En;
	
public class OpenBarTest implements En{

	WebDriver driver = null;
	
	
	public  OpenBarTest()
	{
		
		Given("^I Open the browser$", () -> {
			 driver = WebDriverConfig.getIE();
		});
		
		Given("^I navigate to \"([^\"]*)\"$", (String arg1) -> {
			driver.get(arg1);
		});

		Given("^I enter \"([^\"]*)\" into the field with id \"([^\"]*)\"$", (String arg1, String arg2) -> {
			 driver.findElement(By.id(arg2)).sendKeys(arg1);
		    
		});

		Given("^I enter \"([^\"]*)\" as Password into the field with id \"([^\"]*)\"$", (String arg1, String arg2) -> {
			 driver.findElement(By.id(arg2)).sendKeys(arg1);
		});

		
		When("^I click on the element with id \"([^\"]*)\"$", (String arg1) -> {
			 driver.findElement(By.id(arg1)).click();
		});

		When("^I wait for (\\d+) seconds$", (Integer arg1) -> {
			driver.manage().timeouts().implicitlyWait(arg1, TimeUnit.SECONDS);
		});

		Then("^I should be loggedIn$", () -> {
			assertEquals(driver.findElement(By.id("welcome")).getText(),"WELCOME TESTADMIN USER" );
			
		});

	}

	
	
}
