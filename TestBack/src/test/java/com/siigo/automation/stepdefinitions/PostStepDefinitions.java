package com.siigo.automation.stepdefinitions;

import com.siigo.automation.exceptions.MessageError;
import com.siigo.automation.models.MessageCollection;
import com.siigo.automation.tasks.PostApi;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class PostStepDefinitions {

    @Before
    public void initialSetUp() {
        setTheStage(new OnlineCast());
    }

    @Given("^(.*) connect to (.*)$")
    public void userConnectToUrl(String actor, String url) {
        theActorCalled(actor).whoCan(CallAnApi.at(url));
    }

    @When("^post user info from (.*) with$")
    public void postUserInfoFrom(String path, DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(PostApi.is(path, dataTable));
    }

    @Then("^validate (\\d+)$")
    public void validateInfo(int code) {
        theActorInTheSpotlight()
                .should(seeThatResponse(response -> response.statusCode(code))
                        .orComplainWith(MessageError.class, MessageCollection.MSG_CREATE_UNSUCCESSFUL.getMsg()));
    }
}
