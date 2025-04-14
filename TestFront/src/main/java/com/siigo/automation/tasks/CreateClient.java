package com.siigo.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.siigo.automation.userinterfaces.CreateUserClient.BTN_SAVE;

public class CreateClient implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_SAVE));
    }

    public static CreateClient with() {
        return Tasks.instrumented(CreateClient.class);
    }
}
