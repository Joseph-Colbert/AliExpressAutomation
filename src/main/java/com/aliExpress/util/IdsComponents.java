package com.aliExpress.util;

import io.fluentlenium.core.FluentPage;
import io.fluentlenium.core.domain.FluentWebElement;
import io.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.support.FindBy;

@Wait
public class IdsComponents extends FluentPage {

    @FindBy(css = "input[id='search-words']")
    public FluentWebElement searchButton;

    @FindBy(xpath = "//button[@class='comet-v2-btn comet-v2-btn-large add-to-cart--addtocart--Qhoji3M comet-v2-btn-important']")
    public FluentWebElement addToCartButton;

    @FindBy(css = "div[class='comet-v2-input-number'] div[class='comet-v2-input-number-btn comet-v2-input-number-btn-increase']")
    public FluentWebElement increaseButton    ;

    @FindBy(css = "a[target='_self']")
    public FluentWebElement goToCartButton;

}
