package io.cucumber.examples.visualtest;

import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.github.bonigarcia.wdm.WebDriverManager.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("io/cucumber/examples/visualtest")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
public class RunCucumberTest {
    @BeforeAll
    public static void setupWebDriver() {
        chromedriver().setup();
    }
}

