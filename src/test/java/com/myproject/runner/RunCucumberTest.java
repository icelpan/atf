package com.myproject.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@StoryTag",
        features = {"scr/test/resources/features/myproject-e2e"},
        glue = {"com.myproject"},
        plugin = {"pretty", "html:target/cucumber-reports/reports.html"},
        stepNotifications = true)
public class RunCucumberTest {
}
