package com.siigo.automation.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateInfo implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().jsonPath().get().toString();
    }
    public static ValidateInfo is(){
        return new ValidateInfo();
    }
}
