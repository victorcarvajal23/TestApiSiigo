package com.siigo.automation.tasks;

import com.siigo.automation.interactions.Shadow;
import com.siigo.automation.interactions.WaitFor;
import com.siigo.automation.utils.Convert;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import java.util.Map;

import static com.siigo.automation.userinterfaces.CreateUserClient.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillObservations implements Task {

    DataTable dataTable;

    public FillObservations(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> data = Convert.mapOf(dataTable);
        actor.attemptsTo(WaitUntil.the(BAR, isVisible()).forNoMoreThan(30).seconds()
                , WaitFor.seconds(3)
                , Scroll.to(OPEN_OBSERVATIONS)
                , Click.on(OPEN_OBSERVATIONS)
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_OBSERVATIONS), CSS_OBSERVATIONS, data.get("observaciones"))
        );
    }

    public static FillObservations with(DataTable dataTable) {
        return Tasks.instrumented(FillObservations.class, dataTable);
    }
}
