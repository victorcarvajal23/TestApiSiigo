package com.siigo.automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/new_client.feature",
        glue = "com.siigo.automation.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class NewClient {
}
