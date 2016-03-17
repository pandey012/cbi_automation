package com.cbi.helper;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SharedDriver extends EventFiringWebDriver {
    private static final WebDriver REAL_DRIVER = setDriver();
	//private static final WebDriver REAL_DRIVER = new FirefoxDriver();
	private static final String SAUCE_URL = "http://hpandey:f0d2ae28-9d83-4248-ba3b-1d54756cbc9e@ondemand.saucelabs.com:80/wd/hub";

    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            REAL_DRIVER.close();
        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public SharedDriver() {
        super(REAL_DRIVER);
    }

	public static WebDriver setDriver()
	{
		WebDriver driver = null;
		if(REAL_DRIVER == null)
		{
			DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("platform", System.getenv("platform"));
	        caps.setCapability("browserName", System.getenv("browserName"));
	        caps.setCapability("version", System.getenv("version"));
	        caps.setCapability("name", "OpenBar Features Test");
		    try {
		    	driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			}
		}
		 
			
		return driver;
		 
	}
    @Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException("You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
      
        
        
    }

    @Before
    public void deleteAllCookies() {
        manage().deleteAllCookies();
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        try {
            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
    }
}