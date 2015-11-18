package com.cbi.step_definitions;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.java8.En;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(
				features = {"/resources/features"})
		
public class OpenBarTest implements En{

	WebDriver driver = null;
	private static final String SAUCE_URL = "http://hpandey:f0d2ae28-9d83-4248-ba3b-1d54756cbc9e@ondemand.saucelabs.com:80/wd/hub";
	ArrayList<WebDriver> browsers = new ArrayList<WebDriver>();
	
	/*@cucumber.api.java.Before
	public void setBrowsers() throws MalformedURLException
	{
		//driver = getChrome();
		browsers.add(getFirefox());
		browsers.add(getChrome());
		browsers.add(getIE());
	}*/

	public WebDriver getFirefox() 
	{
		
		DesiredCapabilities caps = DesiredCapabilities.firefox();
	    caps.setCapability("platform", "Windows 10");
	    caps.setCapability("version", "42");
	    caps.setCapability("name", "OpenBar Login - Firefox Test");
		
	    try{
	    	
	    	driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
	    	
	    }
		catch(Exception e)
	    {
			e.printStackTrace();;
	    }
	    return driver;
		
	}
	
	
	public WebDriver getChrome()
	{
		 DesiredCapabilities caps = DesiredCapabilities.chrome();
		    caps.setCapability("platform", "Mac OS X 10.11");
		    caps.setCapability("version", "46.0");
		    caps.setCapability("name", "OpenBar Login -  Chrome Test");
			
		    try{
		    	
		    	driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
		    	
		    }
			catch(Exception e)
		    {
				e.printStackTrace();;
		    }
		    return driver;
			
	}
	
	public WebDriver getIE() 
	{
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	    caps.setCapability("platform", "Windows 10");
	    caps.setCapability("version", "11");
	    caps.setCapability("name", "Sauce Sample IE Test");
		
	    try{
	    	
	    	driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
	    	
	    }
		catch(Exception e)
	    {
			e.printStackTrace();;
	    }
	    return driver;
		
	}
	

	
	public  OpenBarTest()
	{

		Given("^I use Chrome Browser$", () -> {
		   driver = getIE();
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
		
		Then("^I close the browser$", () -> {
		   driver.quit();
		});
	}

	
	
}
