package com.siigo.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class GetText implements Question<String> {

    private Target target;

    public GetText(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(target, isVisible()).forNoMoreThan(15).seconds());
        return target.resolveFor(actor).getText();
    }

    public static GetText ofField(Target target) {
        return new GetText(target);
    }

}
