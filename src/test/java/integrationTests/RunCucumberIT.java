package integrationTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Created by Anniek van Dijk on 16-6-2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
     //   plugin = { "json:target/cucumber/cucumber.json" },
        plugin = { "pretty", "junit:target/reports/IT/Cucumber.xml" },
        features = "src/test/resources/features",
        strict = true
)
public class RunCucumberIT {
    // No implementation required
}