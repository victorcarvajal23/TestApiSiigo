package com.siigo.automation.stepdefinitions;

import com.siigo.automation.tasks.DeleteApi;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteStepDefinitions {

    @When("^delete user info from (.*) with (.*)$")
    public void deleteUserInfoFromApiUsersWith(String path, String id) {
        theActorInTheSpotlight().attemptsTo(DeleteApi.user(path, id)
        );
    }
}
