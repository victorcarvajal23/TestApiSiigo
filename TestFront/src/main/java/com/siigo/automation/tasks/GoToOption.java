package com.siigo.automation.tasks;

import com.siigo.automation.interactions.Shadow;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static com.siigo.automation.userinterfaces.HomePage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GoToOption implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(OPTION, isVisible()).forNoMoreThan(40).seconds()
                , Shadow.click(SCRIPT_OPTION, By.xpath(SHADOW_BY_CLASS), CSS_OPTION)
                , Shadow.click(SCRIPT_OPTION, By.xpath(SHADOW_BY_CLASS), CSS_CLIENTS)

        );

    }

    public static GoToOption of() {
        return Tasks.instrumented(GoToOption.class);
    }
}
