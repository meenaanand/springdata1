package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "..\\springdata1\\src\\test\\java\\Features", 
glue = "definitions", dryRun = false, strict = true,
plugin = { "pretty", "html:target/html", "json:target/cucumber.json" })

public class Run {
}