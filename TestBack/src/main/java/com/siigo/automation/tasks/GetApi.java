package com.siigo.automation.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetApi implements Task {

    String path;
    String id;

    public GetApi(String path, String id) {
        this.path = path;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (id != null) {
            actor.attemptsTo(Get.resource(path + id));
        } else {
            actor.attemptsTo(Get.resource(path)
                    .with(requestSpecification -> requestSpecification.queryParam("page", 2)));
        }
        SerenityRest.lastResponse().prettyPeek();
    }

    public static GetApi user(String path, String id) {
        return Tasks.instrumented(GetApi.class, path, id);
    }

    public static GetApi users(String path) {
        return Tasks.instrumented(GetApi.class, path, null);
    }
}
