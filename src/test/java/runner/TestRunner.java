package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
				glue = {"stepDefinitions"},
				monochrome = true,      
				plugin = {"pretty", "html:target/HTMLReport.html",
						"json:target/cucumber.json"},      
				tags = "@regression"     ) 
public class TestRunner {

}