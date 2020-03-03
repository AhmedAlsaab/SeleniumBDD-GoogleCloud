package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://GCPAutomation//GCPTestAutomation//Features",
        glue = "StepDefinitions",
        tags = {"@FirstTag"}
        )
public class TestRunner {




}
