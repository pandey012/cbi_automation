package com.cbi.step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cbi.helper.WebDriverConfig;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;


public class OpenBarToDoSteps {
	
	
	WebDriver driver;
	public OpenBarToDoSteps(WebDriverConfig driver)
	{
		this.driver = driver.getDriver();
		
	}
	
	
	@When("^I clicked on View All ToDo Link \"([^\"]*)\"$")
	public void i_clicked_on_View_All_ToDo_Link(String className) throws Throwable {
		//driver.findElement(By.className(className)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}



	@Then("^I should land on ToDo Page$")
	public void i_should_land_on_ToDo_Page() throws Throwable {
		//String expedted = driver.findElement(By.xpath("/html/body/div[1]/form/div[3]/div/div[2]/div/h2")).getText();
	   //assertEquals(expedted, "TO DOs");
	}

}
