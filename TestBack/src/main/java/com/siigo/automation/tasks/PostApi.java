package com.siigo.automation.tasks;


import com.siigo.automation.utils.Convert;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostApi implements Task {

    DataTable data;
    String path;

    public PostApi(String path, DataTable data) {
        this.data = data;
        this.path = path;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Post.to(path)
                .with(requestSpecification -> requestSpecification.body(Convert.mapOf(data))
                        .relaxedHTTPSValidation()));
        SerenityRest.lastResponse().prettyPeek();

    }


    public static PostApi is(String path, DataTable data) {
        return Tasks.instrumented(PostApi.class, path, data);
    }
}
