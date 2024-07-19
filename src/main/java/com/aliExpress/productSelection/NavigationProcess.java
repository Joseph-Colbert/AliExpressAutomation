package com.aliExpress.productSelection;

import com.aliExpress.util.IdsComponents;
import io.fluentlenium.core.FluentPage;
import io.fluentlenium.core.annotation.Page;
import io.fluentlenium.core.annotation.PageUrl;
import io.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
        // Mover el ratón al elemento y realizar clic
        WebElement referenceElement = getDriver().findElement(By.tagName("body"));
        // Crear una instancia de Actions
        Actions actions = new Actions(getDriver());

        // Agregar un marcador visual con JavaScript
        executeScript(
                "var elem = document.createElement('div');" +
                        "elem.id = 'mouse-marker';" +
                        "elem.style.position = 'absolute';" +
                        "elem.style.width = '10px';" +
                        "elem.style.height = '10px';" +
                        "elem.style.backgroundColor = '#FF00FF';" +
                        "elem.style.borderRadius = '50%';" +
                        "elem.style.zIndex = '10000';" +
                        "document.body.appendChild(elem);" +
                        "elem.style.left = arguments[0] + 'px';" +
                        "elem.style.top = arguments[1] + 'px';",
                400, 500
        );

        // Esperar un poco para visualizar el marcador
        try {
            Thread.sleep(1000); // Esperar 2 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Mover el mouse al elemento y realizar un clic
        actions.moveByOffset(400, 500).click().perform();

        // Quitar el marcador visual después del clic
        executeScript(
                "var elem = document.getElementById('mouse-marker');" +
                        "if (elem) { elem.parentNode.removeChild(elem); }"
        );
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
