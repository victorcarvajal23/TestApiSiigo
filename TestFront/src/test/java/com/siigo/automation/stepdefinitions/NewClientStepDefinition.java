package com.siigo.automation.stepdefinitions;

import com.siigo.automation.exceptions.MessageError;
import com.siigo.automation.models.MessageCollection;
import com.siigo.automation.questions.GetText;
import com.siigo.automation.tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.siigo.automation.userinterfaces.CreateUserClient.MESSAGE;
import static com.siigo.automation.utils.Constants.URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.containsString;

public class NewClientStepDefinition {

    @Before
    public void init() {
        setTheStage(new OnlineCast());
    }

    @Given("^the user (.*) sing in siigo$")
    public void theUserSingInSiigo(String name) {
        theActorCalled(name).attemptsTo(Open.url(URL),
                Login.with());
    }

    @When("go to menu crear cliente")
    public void goToMenuCrearCliente() {
        theActorInTheSpotlight().attemptsTo(GoToOption.of());

    }

    @Then("fill basic data")
    public void fillBasicData(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(FillBasicData.with(dataTable));
    }

    @Then("fill billing and shipping information")
    public void fillBillingAndShippingInformation(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(FillBilling.with(dataTable));
    }


    @Then("fill contact information")
    public void fillContactInformation(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(FillContact.with(dataTable));
    }

    @Then("fill seller and collector")
    public void fillSellerAndCollector(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(FillSellerCollector.with(dataTable));
    }

    @Then("fill observations")
    public void fillObservations(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(FillObservations.with(dataTable));
    }

    @Then("^create a new client an view message (.*)$")
    public void createANewClient(String message) {
        theActorInTheSpotlight().attemptsTo(CreateClient.with());
        theActorInTheSpotlight()
                .should(seeThat(GetText.ofField(MESSAGE), containsString(message))
                        .orComplainWith(MessageError.class, MessageCollection.MSG_CREATE_UNSUCCESSFUL.getMsg()));
    }
}
