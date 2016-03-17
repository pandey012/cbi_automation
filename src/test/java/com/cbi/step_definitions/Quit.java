package com.cbi.step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cbi.helper.WebDriverConfig;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Quit {

	WebDriver driver;
	public Quit(WebDriverConfig driver)
	{
		this.driver = driver.getDriver();
	}
	
	@Given("^I am on OpenBar Home Page \"([^\"]*)\"$")
	public void i_am_on_OpenBar_Home_Page(String arg1) throws Throwable {
		driver.findElement(By.className("navbar-brand")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
	    
		driver.quit();
		
	}

	
}
