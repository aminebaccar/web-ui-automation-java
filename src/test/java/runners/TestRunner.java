package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        plugin = {
                "pretty",  // Prints test execution details in the console
                "html:target/cucumber-report.html",  // Generates HTML report
                "json:target/cucumber.json",  // Generates JSON report (useful for CI/CD)
                "junit:target/cucumber.xml"  // JUnit-compatible XML report
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
