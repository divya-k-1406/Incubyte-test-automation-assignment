package com.incubyte.testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/resources/features",
    glue = "com.incubyte.stepDefinitions",
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class testRunner {
}
