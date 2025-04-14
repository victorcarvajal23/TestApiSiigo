package com.siigo.automation.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteApi implements Task {

    String path;
    String id;

    public DeleteApi(String path, String id) {
        this.path = path;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(path + id));
        SerenityRest.lastResponse().prettyPeek();
    }

    public static DeleteApi user(String path, String id) {
        return Tasks.instrumented(DeleteApi.class, path, id);
    }
}
