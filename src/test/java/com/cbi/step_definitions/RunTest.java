package com.cbi.step_definitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/"}, tags = {"@OpenbarLogin , @NewsFeature, @Search , @Footer, @TODO, @Quit"}, plugin = {"json:target/cucumber-report.json"})
//@CucumberOptions()
public class RunTest {

}
