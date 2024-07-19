package com.aliExpress.productSelection;

import com.aliExpress.util.IdsComponents;
import io.fluentlenium.core.FluentPage;
import io.fluentlenium.core.annotation.Page;
import io.fluentlenium.core.annotation.PageUrl;
import io.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

@PageUrl(com.aliExpress.util.AliExpressAbstract.URLALIEXPRESS)
@Wait
public class NavigationProcess extends FluentPage {
    private static final String SEARCH_FORM_HOMEPAGE = "#search_form_homepage";

    @Page
    public IdsComponents idsComponents;

    public NavigationProcess addProduct(String productName) {
        idsComponents.searchButton.write(productName).getElement().sendKeys(Keys.ENTER);
        waitUntilEnd();
        idsComponents.firstProduct.click();
        waitUntilEnd();
        waitUntilEnd();
        idsComponents.addToCartButton.click();
        waitUntilEnd();
        idsComponents.increaseButton.click();
        waitUntilEnd();
        idsComponents.goToCartButton.click();
        waitUntilEnd();
        return this;
    }

    /**
     * Se la utiliza para dar tiempo de espera entre operaciones.
     */
    private void waitUntilEnd() {
        await().atMost(60, TimeUnit.SECONDS).until(el(SEARCH_FORM_HOMEPAGE)).not().present();
    }
}
