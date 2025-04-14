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

public class FillBilling implements Task {

    DataTable dataTable;

    public FillBilling(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> data = Convert.mapOf(dataTable);
        actor.attemptsTo(WaitUntil.the(BAR, isVisible()).forNoMoreThan(30).seconds()
                , WaitFor.seconds(3)
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_NAMES_BILLING), CSS_NAMES_BILLING, data.get("nombresFacturacion"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_LAST_NAMES_BILLING), CSS_LAST_NAMES_BILLING, data.get("apellidosFacturacion"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_MAIL), CSS_MAIL, data.get("correo"))
                , Shadow.click(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_IVA), CSS_IVA_LIST)
                , Shadow.click(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_IVA), String.format(CSS_IVA, Convert.intOfIVA(data.get("tipoRegimenIva"))))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_IND_BILLING), CSS_IND_BILLING, data.get("indicativoFacturacion"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_NUMBER_BILLING), CSS_NUMBER_BILLING, data.get("telefonoFacturacion"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_CODE_BILLING), CSS_CODE_BILLING, data.get("codigoPostal"))
                , Click.on(CBX_FISCAL.of(data.get("responsabilidadFiscal")))

        );
    }

    public static FillBilling with(DataTable dataTable) {
        return Tasks.instrumented(FillBilling.class, dataTable);
    }
}
