package com.siigo.automation.tasks;


import com.siigo.automation.utils.Convert;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class PutApi implements Task {

    DataTable data;
    String path;
    String id;

    public PutApi(String path, String id, DataTable data) {
        this.path = path;
        this.id = id;
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Put.to(path)
                .with(requestSpecification -> requestSpecification.body(Convert.mapOf(data))
                        .relaxedHTTPSValidation()));
        SerenityRest.lastResponse().prettyPeek();

    }


    public static PutApi with(String path, String id, DataTable data) {
        return Tasks.instrumented(PutApi.class, path, id, data);
    }
}
