package com.cbi.helper;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class WebDriverConfig {

	private static WebDriver driver = null;
	//private static final String SAUCE_URL = "http://hpandey:f0d2ae28-9d83-4248-ba3b-1d54756cbc9e@ondemand.saucelabs.com:80/wd/hub";
	private static final String SAUCE_URL = "http://hpandey01:af3938ea-00c3-4f9c-97b0-5bf733eccd7b@ondemand.saucelabs.com:80/wd/hub";
	
	public static WebDriver getFirefoxDriver() 
	{
		
		DesiredCapabilities caps = DesiredCapabilities.firefox();
	    caps.setCapability("platform", "Windows 10");
	    caps.setCapability("version", "42");
	    caps.setCapability("name", "OpenBar Login - Firefox Test");
		
	    try{
	    	if(driver == null)
	    		driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
	    	
	    }
		catch(Exception e)
	    {
			e.printStackTrace();;
	    }
	    return driver;
		
	}
	
	
	public static WebDriver getChrome()
	{
		 DesiredCapabilities caps = DesiredCapabilities.chrome();
		    caps.setCapability("platform", "Mac OS X 10.11");
		    caps.setCapability("version", "46.0");
		    caps.setCapability("name", "OpenBar Login -  Chrome Test");
			
		    try{
		    	if(driver == null)
		    		driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
		    	
		    }
			catch(Exception e)
		    {
				e.printStackTrace();;
		    }
		    return driver;
			
	}
	
	public static WebDriver getIE() 
	{
		
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	    caps.setCapability("platform", "Windows 10");
	    caps.setCapability("version", "11");
	    caps.setCapability("name", "Sauce Sample IE Test");
		
	    try{
	    	
	    	if(driver == null)
	    		driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
	  
	    	
	    }
		catch(Exception e)
	    {
			e.printStackTrace();;
	    }
	    return driver;
		
	}
	
	public static WebDriver getLocalFirefox()
	{
		DesiredCapabilities caps = DesiredCapabilities.firefox();
	    caps.setCapability("platform", "Windows 10");
	    caps.setCapability("version", "42");
	    caps.setCapability("name", "OpenBar Login - Firefox Test");
		
	    try{
	    	if(driver == null)
	    		driver = new FirefoxDriver();
	    	
	    }
		catch(Exception e)
	    {
			e.printStackTrace();;
	    }
	    return driver;
	}
	

	
}
