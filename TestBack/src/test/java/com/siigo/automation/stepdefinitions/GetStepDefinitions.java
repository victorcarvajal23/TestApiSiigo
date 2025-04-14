package com.siigo.automation.stepdefinitions;

import com.siigo.automation.tasks.GetApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetStepDefinitions {

    @Given("^get user info from (.*) with (.*)$")
    public void getUserInfoFromApi(String path, String id) {
        theActorInTheSpotlight().attemptsTo(GetApi.user(path, id));
    }

    @When("^get users info from (.*)$")
    public void getUserInfoFromApiUsers(String path) {
        theActorInTheSpotlight().attemptsTo(GetApi.users(path));
    }

    @Then("^validate (\\d+) and (\\d+)$")
    public void validateInfoId(int code, int id) {
        theActorInTheSpotlight()
                .should(seeThatResponse(response -> response.statusCode(code).body("data.id", equalTo(id))));
    }
}
