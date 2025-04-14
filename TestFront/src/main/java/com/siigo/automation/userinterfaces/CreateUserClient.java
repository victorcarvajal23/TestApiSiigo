package com.siigo.automation.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CreateUserClient {

    public static final Target BAR = Target.the("bar").locatedBy("#sticky");
    public static final String SCRIPT_CLIENT = "return arguments[0].shadowRoot.querySelector(arguments[1])";
    public static final String XPATH_SHADOW_TYPE = "(//siigo-dropdownlist-web[@class='hydrated'])[2]";
    public static final String CSS_LIST_TYPE = ".mdc-select__anchor.mdc-ripple-upgraded";
    public static final String CSS_TYPE = "span.mdc-list-item__text:nth-of-type(%d)";
    public static final String XPATH_SHADOW_TYPE_DOCUMENT = "(//siigo-dropdownlist-web[@class='hydrated'])[3]";
    public static final String CSS_LIST_TYPE_DOCUMENT = ".mdc-select__anchor.mdc-ripple-upgraded";
    public static final String CSS_TYPE_DOCUMENT = "li.mdc-list-item:nth-of-type(%d)";
    public static final String XPATH_SHADOW_DOCUMENT = "(//siigo-identification-input-web[@class='hydrated'])[1]";
    public static final String CSS_DOCUMENT = ".mdc-text-field__input.input-identification";
    public static final String CSS_DV = "#input-check-digit";
    public static final String XPATH_SHADOW_CODE = "(//siigo-textfield-web[@class='hydrated'])[1]";
    public static final String CSS_CODE = ".mdc-text-field__input";
    public static final String XPATH_SHADOW_NAMES = "(//siigo-textfield-web[@class='hydrated'])[2]";
    public static final String CSS_NAMES = ".mdc-text-field__input";
    public static final String XPATH_SHADOW_LAST_NAMES = "(//siigo-textfield-web[@class='hydrated'])[3]";
    public static final String CSS_LAST_NAMES = ".mdc-text-field__input";
    public static final String XPATH_SHADOW_NAME_SHOP = "(//siigo-textfield-web[@class='hydrated'])[5]";
    public static final String CSS_NAME_SHOP = ".mdc-text-field__input";
    public static final String XPATH_SHADOW_CITY = "//siigo-autocomplete-web[@class='hydrated']";
    public static final String CSS_CITY = "#divWrapperAutocompletecity";
    public static final String CSS_CITY_ENTER = "#inputAutocompletecity";
    public static final String CSS_SELECT_CITY = "#divTDAutocompletecity1";
    public static final String XPATH_SHADOW_ADDRESS = "(//siigo-textfield-web[@class='hydrated'])[6]";
    public static final String CSS_ADDRESS = ".mdc-text-field__input";
    public static final String XPATH_PHONE = "//siigo-phone-web[@class='hydrated']";
    public static final String CSS_IND = "input[aria-labelledby=\"inputIndicative0\"]";
    public static final String CSS_NUMBER = "input[aria-labelledby=\"inputNumber0\"]";
    public static final String CSS_EXT = "input[aria-labelledby=\"inputExtension0\"]";

    public static final String XPATH_SHADOW_NAMES_BILLING = "(//siigo-textfield-web[@class='hydrated'])[7]";
    public static final String CSS_NAMES_BILLING = ".mdc-text-field__input";
    public static final String XPATH_SHADOW_LAST_NAMES_BILLING = "(//siigo-textfield-web[@class='hydrated'])[8]";
    public static final String CSS_LAST_NAMES_BILLING = ".mdc-text-field__input";
    public static final String XPATH_SHADOW_MAIL = "(//siigo-textfield-web[@class='hydrated'])[9]";
    public static final String CSS_MAIL = ".mdc-text-field__input";
    public static final String XPATH_SHADOW_IVA = "(//siigo-dropdownlist-web[@class='hydrated'])[4]";
    public static final String CSS_IVA_LIST = ".mdc-select__anchor.mdc-ripple-upgraded";
    public static final String CSS_IVA = ".mdc-list-item:nth-of-type(%d)";
    public static final String XPATH_SHADOW_IND_BILLING = "(//siigo-textfield-web[@class='hydrated'])[10]";
    public static final String CSS_IND_BILLING = ".mdc-text-field__input";
    public static final String XPATH_SHADOW_NUMBER_BILLING = "(//siigo-textfield-web[@class='hydrated'])[11]";
    public static final String CSS_NUMBER_BILLING = ".mdc-text-field__input";
    public static final String XPATH_SHADOW_CODE_BILLING = "(//siigo-textfield-web[@class='hydrated'])[12]";
    public static final String CSS_CODE_BILLING = ".mdc-text-field__input";
    public static final Target CBX_FISCAL = Target.the("Checkbox fiscal").locatedBy("//div[normalize-space(text())='{0}']/ancestor::label//div[contains(@class, 'control_indicator')]");

    public static final Target OPEN_CONTACT = Target.the("Open contact").locatedBy("(//*[@class='clickable'])[1]");
    public static final String XPATH_SHADOW_NAMES_CONTACT = "//siigo-textfield-web[@name='FirstName']";
    public static final String CSS_NAMES_CONTACT = ".mdc-text-field__input";
    public static final String XPATH_SHADOW_LAST_NAMES_CONTACT = "//siigo-textfield-web[@name='LastName']";
    public static final String CSS_LAST_NAMES_CONTACT = ".mdc-text-field__input";
    public static final String XPATH_SHADOW_MAIL_CONTACT = "//siigo-emailinput-web[@name='Email']";
    public static final String CSS_MAIL_CONTACT = ".mdc-text-field__input";
    public static final String XPATH_SHADOW_CHARGE_CONTACT = "//siigo-textfield-web[@name='Charge']";
    public static final String CSS_CHARGE_CONTACT = ".mdc-text-field__input";
    public static final String XPATH_SHADOW_IND_CONTACT = "//siigo-textfield-web[@name='Indicative']";
    public static final String CSS_IND_CONTACT = ".mdc-text-field__input";
    public static final String XPATH_SHADOW_NUMBER_CONTACT = "//siigo-textfield-web[@name='Number']";
    public static final String CSS_NUMBER_CONTACT = ".mdc-text-field__input";

    public static final Target OPEN_SELLER = Target.the("Open seller and collector").locatedBy("(//*[@class='clickable'])[4]");
    public static final String XPATH_SHADOW_SELLER = "(//siigo-autocomplete-web[@CLASS='hydrated'])[2]";
    public static final String CSS_SELLER = ".mdc-text-field__input";
    public static final String XPATH_SHADOW_COLLECTOR = "(//siigo-autocomplete-web[@CLASS='hydrated'])[3]";
    public static final String CSS_COLLECTOR= ".mdc-text-field__input";

    public static final Target OPEN_OBSERVATIONS= Target.the("Open observations").locatedBy("(//*[@class='clickable'])[7]");
    public static final String XPATH_SHADOW_OBSERVATIONS = "//siigo-textarea-web[@class='hydrated']";
    public static final String CSS_OBSERVATIONS = "#textareainput";


    public static final Target BTN_SAVE = Target.the("button save").locatedBy("//*[@class='button green filled']");
    public static final Target MESSAGE = Target.the("button save").locatedBy("//*[@class='toast-top-right toast-container']");

}
