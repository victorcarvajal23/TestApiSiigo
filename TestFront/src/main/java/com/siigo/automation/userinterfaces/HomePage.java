package com.siigo.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target OPTION = Target.the("menu option").locatedBy("//*[@class='data-siigo-five9 hydrated']");
    public static final String SHADOW_BY_CLASS = "//*[@class='data-siigo-five9 hydrated']";
    public static final String CSS_OPTION = "siigo-button-atom.hydrated[text='Crear']";
    public static final String CSS_CLIENTS = "a[data-value='Clientes']";
    public static final String SCRIPT_OPTION = "return arguments[0].shadowRoot.querySelector(arguments[1])";

}
