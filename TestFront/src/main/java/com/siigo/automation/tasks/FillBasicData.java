package com.siigo.automation.tasks;

import com.siigo.automation.interactions.Shadow;
import com.siigo.automation.interactions.WaitFor;
import com.siigo.automation.utils.Convert;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import java.util.Map;

import static com.siigo.automation.userinterfaces.CreateUserClient.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillBasicData implements Task {

    DataTable dataTable;

    public FillBasicData(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> data = Convert.mapOf(dataTable);
        actor.attemptsTo(WaitUntil.the(BAR, isVisible()).forNoMoreThan(30).seconds()
                , Shadow.click(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_TYPE), CSS_LIST_TYPE)
                , WaitFor.seconds(3)
                , Shadow.click(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_TYPE), String.format(CSS_TYPE, Convert.intOfType(data.get("tipo"))))
                , Shadow.click(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_TYPE_DOCUMENT), CSS_LIST_TYPE_DOCUMENT)
                , Shadow.click(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_TYPE_DOCUMENT), String.format(CSS_TYPE_DOCUMENT, Convert.intOfTypeDocument(data.get("tipoIdentificacion"))))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_DOCUMENT), CSS_DOCUMENT, Convert.document(data.get("identificacion")))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_DOCUMENT), CSS_DV, data.get("dv"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_CODE), CSS_CODE, data.get("codigoSucursal"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_NAMES), CSS_NAMES, data.get("nombres"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_LAST_NAMES), CSS_LAST_NAMES, data.get("apellidos"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_NAME_SHOP), CSS_NAME_SHOP, data.get("nombreComercial"))
                , Shadow.click(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_CITY), CSS_CITY)
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_CITY), CSS_CITY_ENTER, data.get("ciudad"))
                , WaitFor.seconds(3)
                , Shadow.click(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_CITY), CSS_SELECT_CITY)
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_SHADOW_ADDRESS), CSS_ADDRESS, data.get("direccion"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_PHONE), CSS_IND, data.get("indicativo"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_PHONE), CSS_NUMBER, data.get("numeroTelefono"))
                , Shadow.enterValue(SCRIPT_CLIENT, By.xpath(XPATH_PHONE), CSS_EXT, data.get("extension"))
        );

    }

    public static FillBasicData with(DataTable dataTable) {
        return Tasks.instrumented(FillBasicData.class, dataTable);
    }
}
