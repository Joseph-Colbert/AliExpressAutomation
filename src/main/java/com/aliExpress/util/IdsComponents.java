package com.aliExpress.util;

import io.fluentlenium.core.FluentPage;
import io.fluentlenium.core.domain.FluentWebElement;
import io.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.support.FindBy;

@Wait
public class IdsComponents extends FluentPage {

    @FindBy(css = "input[id='search-words']")
    public FluentWebElement searchButton;

    @FindBy(css = "button[class='comet-v2-btn comet-v2-btn-large add-to-cart--addtocart--Qhoji3M comet-v2-btn-important'] span")
    public FluentWebElement addToCartButton;

    @FindBy(css = "div[class='comet-v2-input-number'] div[class='comet-v2-input-number-btn comet-v2-input-number-btn-increase']")
    public FluentWebElement increaseButton    ;

    @FindBy(css = "a[target='_self']")
    public FluentWebElement goToCartButton;

    @FindBy(css = "a[class='pc-header--logoImg--mDbiT4k']")
    public FluentWebElement aliExpressMenuButton;

    @FindBy(css = "span[class='delivery-v2--to--Mtweg7y']")
    public FluentWebElement country;

    @FindBy(css = "div[class='select--text--bMMjuMA']")
    public FluentWebElement chooseCountry;

    @FindBy(css = "div[class='select--search--aY4rTpn'] input")
    public FluentWebElement writeCountry;

    @FindBy(css = "div[class='select--item--P0u5Ru4']")
    public FluentWebElement selectCountry;

    @FindBy(css = "html > body > div:nth-of-type(10) > div:nth-of-type(2) > div > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(3) > div > div:nth-of-type(1)")
    public FluentWebElement selectCity;

    @FindBy(xpath = "//div[contains(@data-spm-anchor-id, 'a2g0o.detail.0.i15.223dhT8ohT8oRm')]")
    public FluentWebElement chooseCity;

    @FindBy(css = "div[data-spm-anchor-id='a2g0o.detail.0.i10.223dhT8ohT8oRm']")
    public FluentWebElement selectC;

    @FindBy(xpath = "/html/body/div[11]/div[2]/div/div[2]/div[1]/div[4]/div/div[2]/div[7]")
    public FluentWebElement chooseC;

    @FindBy(css = "button[class='comet-v2-btn comet-v2-btn-primary comet-v2-btn-important']")
    public FluentWebElement applyButton;

    @FindBy(css = "div.select--popup--luRb2PW.select--visiblePopup--w5RfpWu")
    public FluentWebElement actionScroll;
}
