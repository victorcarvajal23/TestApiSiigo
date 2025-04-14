package com.siigo.automation.tasks;

import com.siigo.automation.interactions.Shadow;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static com.siigo.automation.userinterfaces.LoginPage.*;
import static com.siigo.automation.utils.Constants.PASS;
import static com.siigo.automation.utils.Constants.USER;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(WaitUntil.the(FIELD_USER, isVisible()).forNoMoreThan(30).seconds()
                , Shadow.enterValue(SCRIPT_LOGIN, By.name(SHADOW_BY_NAME_USER), CSS_NAME_USER, USER)
                , Shadow.enterValue(SCRIPT_LOGIN, By.name(SHADOW_BY_NAME_PASS), CSS_NAME_PASS, PASS)
                , Click.on(BTN_LOGIN)
        );
    }

    public static Login with() {
        return Tasks.instrumented(Login.class);
    }
}
