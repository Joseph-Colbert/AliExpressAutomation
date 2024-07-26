package com.aliExpress.productSelection;

import com.aliExpress.util.Functions;
import com.aliExpress.util.IdsComponents;
import com.aliExpress.util.ScreenShots;
import io.fluentlenium.core.FluentPage;
import io.fluentlenium.core.annotation.Page;
import io.fluentlenium.core.annotation.PageUrl;
import io.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

@PageUrl(com.aliExpress.util.AliExpressAbstract.URLALIEXPRESS)
@Wait
public class NavigationProcess extends FluentPage {

    private static final String SCREENSHOT = "src\\main\\resources\\screenshots\\addToCart\\";

    @Page
    public IdsComponents idsComponents;

    @Page
    public Functions functions;

    @Page
    public ScreenShots screenShots;


    public NavigationProcess selectProduct(String productName) {
        // Asegurarse de que la ventana del navegador está maximizada
        getDriver().manage().window().maximize();
        screenShots.takeScreenShot("1. HomePage", SCREENSHOT, this.getDriver());
        idsComponents.searchButton.write(productName).getElement().sendKeys(Keys.ENTER);
        functions.waitUntilEnd();
        return this;
    }

    public NavigationProcess addProduct(int xOffset, int yOffset) {
        // Crear una instancia de Actions para utilizar codigo selenium
        Actions actions = new Actions(getDriver());
        screenShots.takeScreenShot("2. ProductSelection", SCREENSHOT, this.getDriver());
        // Agregar un marcador visual con JavaScript
        functions.pointer(xOffset, yOffset);
        // Mover el ratón al centro de la ventana y luego a las coordenadas deseadas
        actions.moveByOffset(xOffset, yOffset).click().perform(); // Mover a las coordenadas deseadas y hacer clic
        functions.waitUntilEnd();
        functions.removePointer();
        functions.changePage();
        // Ahora estamos en la nueva ventana
        idsComponents.addToCartButton.click();
        screenShots.takeScreenShot("3. AddToCart", SCREENSHOT, this.getDriver());
        functions.waitUntilEnd();
        idsComponents.increaseButton.click();
        screenShots.takeScreenShot("4. QuantityIncrease", SCREENSHOT, this.getDriver());
        functions.waitUntilEnd();
        idsComponents.goToCartButton.click();
        screenShots.takeScreenShot("5. addToCartMenu", SCREENSHOT, this.getDriver());
        functions.waitUntilEnd();
        idsComponents.aliExpressMenuButton.click();
        functions.waitUntilEnd();
        return this;
    }

    public NavigationProcess addProductScroll(int times, int xOffset, int yOffset) {
        Actions actions = new Actions(getDriver());
        for (int i = 0; i < times; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }
        functions.waitUntilEnd();
        functions.pointer(xOffset, yOffset);
        actions.moveByOffset(xOffset, yOffset).click().perform();
        functions.waitUntilEnd();
        functions.removePointer();
        return this;
    }

    public NavigationProcess selectOptions(int xOffset, int yOffset) {
        Actions actions = new Actions(getDriver());
        functions.waitUntilEnd();
        functions.changePage();
        functions.waitUntilEnd();
        functions.pointer(xOffset, yOffset);
        actions.moveByOffset(xOffset, yOffset).click().perform();
        functions.waitUntilEnd();
        functions.removePointer();
        return this;
    }
}
