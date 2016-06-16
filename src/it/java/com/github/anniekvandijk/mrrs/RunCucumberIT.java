package com.github.anniekvandijk.mrrs;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Created by Anniek van Dijk on 16-6-2016.
 */
public class RunCucumberIT {

    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = { "html:target/cucumber/report.html", "json:target/cucumber-report.json" },
            features = { "src/it/resources/" },
            tags = { "@run"}
    )


    public class RunCucumberTests {
        // No implementation required
    }
}
