package com.aliExpress.util;

import io.fluentlenium.core.FluentPage;
import io.fluentlenium.core.domain.FluentWebElement;
import io.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.support.FindBy;

@Wait
public class IdsComponents extends FluentPage {

    @FindBy(css = "input[id='search-words']")
    public FluentWebElement searchButton;

    @FindBy(css = "div[title*='70'] h3")
    public FluentWebElement firstProduct;

    @FindBy(css = "html > body > div:nth-of-type(5) > div > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div > div:nth-of-type(7) > button:nth-of-type(2)")
    public FluentWebElement addToCartButton;

    @FindBy(css = "div[class='comet-v2-input-number'] div[class='comet-v2-input-number-btn comet-v2-input-number-btn-increase']")
    public FluentWebElement increaseButton    ;

    @FindBy(css = "a[target='_self']")
    public FluentWebElement goToCartButton;

}
