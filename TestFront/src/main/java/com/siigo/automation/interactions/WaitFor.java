package com.siigo.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.concurrent.TimeUnit;

public class WaitFor implements Interaction {

    private final int seconds;


    public WaitFor(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        try {
            TimeUnit.SECONDS.sleep(this.seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public static WaitFor seconds(int seconds) {
        return Tasks.instrumented(WaitFor.class, seconds);
    }
}
