package com.siigo.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target FIELD_USER = Target.the("Field user").locatedBy("//*[@id='username']");
    public static final Target BTN_LOGIN = Target.the("Button login").locatedBy("#login-submit");
    public static final String SHADOW_BY_NAME_USER = "username-input";
    public static final String SHADOW_BY_NAME_PASS = "password-input";
    public static final String CSS_NAME_USER = "#username-input";
    public static final String CSS_NAME_PASS = "#password-input";
    public static final String SCRIPT_LOGIN = "return arguments[0].shadowRoot.querySelector(arguments[1])";
}
