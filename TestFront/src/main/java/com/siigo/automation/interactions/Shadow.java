package com.siigo.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.core.Serenity.getDriver;

public class Shadow implements Interaction {

    private final String script;
    private final String cssIntoShadow;
    private final String text;
    private final ShadowAction action;
    private final By by;

    public Shadow(String script, By by, String cssIntoShadow, String text, ShadowAction action) {
        this.script = script;
        this.by = by;
        this.cssIntoShadow = cssIntoShadow;
        this.text = text;
        this.action = action;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement shadow = driver.findElement(by);
        WebElement element = (WebElement) js.executeScript(script, shadow, cssIntoShadow);
        switch (action) {
            case CLICK -> element.click();
            case ENTER_TEXT -> element.sendKeys(text);
        }

    }

    public static Shadow enterValue(String script, By by, String cssIntoShadow, String text) {
        return Tasks.instrumented(Shadow.class, script, by, cssIntoShadow, text, ShadowAction.ENTER_TEXT);
    }

    public static Shadow click(String script, By by, String cssIntoShadow) {
        return Tasks.instrumented(Shadow.class, script, by, cssIntoShadow, null, ShadowAction.CLICK);
    }

    public enum ShadowAction {
        CLICK,
        ENTER_TEXT
    }
}
