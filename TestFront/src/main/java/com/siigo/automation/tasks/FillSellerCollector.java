package com.siigo.automation.tasks;

import com.siigo.automation.interactions.Shadow;
import com.siigo.automation.interactions.WaitFor;
import com.siigo.automation.utils.Convert;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import java.util.Map;

import static com.siigo.automation.userinterfaces.CreateUserClient.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillSellerCollector implements Task {

    DataTable dataTable;

    public FillSellerCollector(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> data = Convert.mapOf(dataTable);
        actor.attemptsTo(WaitUntil.the(BAR, isVisible()).forNoMoreThan(30).seconds()
                , WaitFor.seconds(3)
                , Click.on(OPEN_SELLER)
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_SELLER), CSS_SELLER, data.get("vendedor"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_COLLECTOR), CSS_COLLECTOR, data.get("cobrador"))
        );


    }

    public static FillSellerCollector with(DataTable dataTable) {
        return Tasks.instrumented(FillSellerCollector.class, dataTable);
    }
}
