package com.github.anniekvandijk.mrrs.it;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Created by Anniek van Dijk on 16-6-2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "html:target/cucumber/report.html", "json:target/cucumber-report.json" },
        features = { "src/it/resources/features" },
        strict = true
)
public class RunCucumberIT {
    // No implementation required
}