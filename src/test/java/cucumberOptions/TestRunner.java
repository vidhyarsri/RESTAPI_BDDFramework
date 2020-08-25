package cucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", //feature file path
                 glue= {"stepDefinitions"},         //path for step Definitions
                 monochrome =true,  //Test results in console are in readable format
                 plugin= {"pretty","html:test-output", "json:target/jsonReports/cucumber-report.json"})
                   //plugin helps with report generation
                   //1. "html:test-output": This will generate an "Html" report under "test-output" folder
                  //2. "json:target/jsonReports/cucumber-report.json": creates logs in "jsonReports" folder, which is used in generating Cucumber HTML reports, in "target" folder  
         

public class TestRunner {
	 //tags= {"@AddPlace"}  
}
