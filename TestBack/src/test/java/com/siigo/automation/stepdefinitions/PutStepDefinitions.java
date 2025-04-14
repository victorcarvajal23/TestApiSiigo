package com.siigo.automation.stepdefinitions;

import com.siigo.automation.tasks.PutApi;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PutStepDefinitions {

    @When("^update user info from (.*) with (.*)$")
    public void updateUserInfoFromApiUsersWith(String path, String id, DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(PutApi.with(path, id, dataTable));
    }
}
