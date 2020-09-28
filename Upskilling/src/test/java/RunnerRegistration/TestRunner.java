package RunnerRegistration;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="RegisterFunctionalities/registration.feature",
glue= {"StepDefinition1"},
plugin= {"json:target/json-report.json","html:target/test-report","junit:target/junit-xml-report.xml"},
dryRun=true
)
public class TestRunner {

}
