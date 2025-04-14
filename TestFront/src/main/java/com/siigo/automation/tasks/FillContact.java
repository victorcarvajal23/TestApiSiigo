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

public class FillContact implements Task {

    DataTable dataTable;

    public FillContact(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> data = Convert.mapOf(dataTable);
        actor.attemptsTo(WaitUntil.the(OPEN_CONTACT, isVisible()).forNoMoreThan(30).seconds()
                , Click.on(OPEN_CONTACT)
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_NAMES_CONTACT), CSS_NAMES_CONTACT, data.get("nombre"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_LAST_NAMES_CONTACT), CSS_LAST_NAMES_CONTACT, data.get("apellido"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_MAIL_CONTACT), CSS_MAIL_CONTACT, data.get("correoContact"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_CHARGE_CONTACT), CSS_CHARGE_CONTACT, data.get("cargo"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_IND_CONTACT), CSS_IND_CONTACT, data.get("indicativoContacto"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_NUMBER_CONTACT), CSS_NUMBER_CONTACT, data.get("telefonoContacto"))
                , WaitFor.seconds(5)

        );

    }

    public static FillContact with(DataTable dataTable) {
        return Tasks.instrumented(FillContact.class, dataTable);
    }
}
