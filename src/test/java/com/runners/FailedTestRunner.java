package com.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "html:target/failed-html-reports"},
        features = "@target/rerun.txt",
        glue = "src/test/java/com/step_defs"

)

public class FailedTestRunner {
}
