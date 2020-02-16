package com.github.anniekvandijk.mrrs.it;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Created by Anniek van Dijk on 16-6-2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "html:target/cucumber/report.html", "json:target/cucumber-report.json" }
        ,features = { "src/it/resources/features" }
)
public class RunCucumberIT {
    // No implementation required
}