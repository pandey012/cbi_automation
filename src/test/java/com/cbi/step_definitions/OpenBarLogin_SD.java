package com.cbi.step_definitions;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cbi.helper.SharedDriver;
import com.cbi.helper.WebDriverConfig;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
	
public class OpenBarLogin_SD  {

	//WebDriver driver = null;
	// private WebDriverConfig webDriverConfig;

	   // PicoContainer injects class ContextSteps
	 /*  public OpenBarLogin_SD (WebDriverConfig webDriverConfig) {
	      //this.webDriverConfig = webDriverConfig;
	     // driver = webDriverConfig.getDriver();
	      
	   }
	   
*/
	    private final WebDriver driver;

	  /*  public OpenBarLogin_SD(SharedDriver webDriver) {
	        this.driver = webDriver;
	    }*/
	    
	    public OpenBarLogin_SD(WebDriverConfig webDriver) {
	        this.driver = webDriver.getDriver() ;
	    }
	   
	   @Given("^I navigate to \"([^\"]*)\"$")
	   public void i_navigate_to(String arg1) throws Throwable {
	       
		   driver.get(arg1);
		   
	      
	   }

	   @Given("^I wait for (\\d+) seconds$")
	   public void i_wait_for_seconds(int arg1) throws Throwable {
		   driver.manage().timeouts().implicitlyWait(arg1, TimeUnit.SECONDS);
	   }

	   @Given("^I enter \"([^\"]*)\" into the field with id \"([^\"]*)\"$")
	   public void i_enter_into_the_field_with_id(String arg1, String arg2) throws Throwable {
		   driver.findElement(By.id(arg2)).sendKeys(arg1);
	   }

	   @Given("^I enter \"([^\"]*)\" as Password into the field with id \"([^\"]*)\"$")
	   public void i_enter_as_Password_into_the_field_with_id(String arg1, String arg2) throws Throwable {
		   driver.findElement(By.id(arg2)).sendKeys(arg1);
	   }

	   @When("^I click on the element with id \"([^\"]*)\"$")
	   public void i_click_on_the_element_with_id(String arg1) throws Throwable {
		   driver.findElement(By.id(arg1)).click();
	   }


	   @Then("^I should be loggedIn$")
	   public void i_should_be_loggedIn() throws Throwable {
		   assertEquals(driver.findElement(By.id("welcome")).getText(),"WELCOME TESTADMIN USER" );
		  
	   }

	
	
}
