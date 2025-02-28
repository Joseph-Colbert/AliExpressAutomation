package com.aliExpress.productSelection;

import com.aliExpress.util.Functions;
import com.aliExpress.util.IdsComponents;
import com.aliExpress.util.ScreenShots;
import io.fluentlenium.core.FluentPage;
import io.fluentlenium.core.annotation.Page;
import io.fluentlenium.core.annotation.PageUrl;
import io.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

    /**
     * Al momento que entramos a la página, maximizamos la ventana del navegador.
     * Realizamos una busqueda y esperamos la respuesta.
     * @param productName
     * @return Page NavigationProcess
     */
    public NavigationProcess selectProduct(String productName) {
        // Asegurarse de que la ventana del navegador está maximizada
        getDriver().manage().window().maximize();
        functions.waitUntilEnd();
        functions.imageSearchBox();
        screenShots.takeScreenShot("1. HomePage", SCREENSHOT, this.getDriver());
        idsComponents.searchButton.write(productName).getElement().sendKeys(Keys.ENTER);
        functions.waitUntilEnd();
        return this;
    }

    /**
     * Añadimos un producto al carrito, tenemos funciones como:
     * Tomar captura de pantalla, mover el raton en pixeles de la página en específico,
     * añadimos y quitamos un marcador del raton y realizamos clicks en los botones seleccionados
     * y cambiamos de ventana a la nueva abierta en el proceso.
     * @param xOffset
     * @param yOffset
     * @return Page NavigationProcess
     */
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
        functions.imageSearchBox();
        screenShots.takeScreenShot("5. AddToCartMenu", SCREENSHOT, this.getDriver());
        functions.waitUntilEnd();
        idsComponents.aliExpressMenuButton.click();
        screenShots.takeScreenShot("6. AliExpressMenu", SCREENSHOT, this.getDriver());
        functions.waitUntilEnd();
        return this;
    }

    /**
     * El for empleado, sirve para poder realizar un scroll en la página, modificando los clicks hacia abajo
     * que se deseen realizar(funcion de selenium), a continuacion, movemos el mouse para seleccionar un producto.
     * @param times
     * @param xOffset
     * @param yOffset
     * @return Page NavigationProcess
     */
    public NavigationProcess addProductScroll(int times, int xOffset, int yOffset) {
        Actions actions = new Actions(getDriver());
        for (int i = 0; i < times; i++) {
            actions.sendKeys(Keys.PAGE_DOWN).perform();
        }
        functions.waitUntilEnd();
        screenShots.takeScreenShot("7. ScrollDown", SCREENSHOT, this.getDriver());
        functions.pointer(xOffset, yOffset);
        actions.moveByOffset(xOffset, yOffset).click().perform();
        functions.waitUntilEnd();
        functions.removePointer();
        return this;
    }

    /**
     * Creamos un apartado para realizar el scroll de una ventana desplegada en el proceso.
     * Para ello, utilizamos JavaScript.
     * @param pixels
     */
    private void scrollDownElement(int pixels) {
        WebElement scrollableElement = getDriver().findElement(By.cssSelector("div.select--popup--luRb2PW.select--visiblePopup--w5RfpWu"));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollBy(0," + pixels + ")", scrollableElement);
    }

    /**
     * Cambiamos la página, realizamos clicks en los botones, escribimos en un apartado input,
     * utilizamos el apartado para realizar el scroll y seleccionamos lo requerido.
     * @param cityName
     * @param scroll
     * @return Page NavigationProcess
     */
    public NavigationProcess selectOptions(String cityName, int scroll) {
        functions.waitUntilEnd();
        functions.changePage();
        functions.waitUntilEnd();
        screenShots.takeScreenShot("8. ProductDetails", SCREENSHOT, this.getDriver());
        idsComponents.country.click();
        screenShots.takeScreenShot("9. CountryAddress", SCREENSHOT, this.getDriver());
        idsComponents.chooseCountry.click();
        functions.waitUntilEnd();
        screenShots.takeScreenShot("10. CountryOptions", SCREENSHOT, this.getDriver());
        idsComponents.writeCountry.write(cityName);
        screenShots.takeScreenShot("11. CountrySelection", SCREENSHOT, this.getDriver());
        idsComponents.selectCountry.click();
        functions.waitUntilEnd();
        screenShots.takeScreenShot("12. Options", SCREENSHOT, this.getDriver());
        idsComponents.selectCity.click();
        functions.waitUntilEnd();
        scrollDownElement(scroll);
        screenShots.takeScreenShot("13. CitySelection", SCREENSHOT, this.getDriver());
        functions.waitUntilEnd();
        idsComponents.chooseCity.click();
        screenShots.takeScreenShot("14. CityOptions", SCREENSHOT, this.getDriver());
        idsComponents.selectC.click();
        functions.waitUntilEnd();
        scrollDownElement(scroll);
        screenShots.takeScreenShot("15. CitySel", SCREENSHOT, this.getDriver());
        idsComponents.chooseC.click();
        functions.waitUntilEnd();
        screenShots.takeScreenShot("16. CorrectData", SCREENSHOT, this.getDriver());
        idsComponents.applyButton.click();
        functions.waitUntilEnd();
        screenShots.takeScreenShot("17. CountryChange", SCREENSHOT, this.getDriver());
        functions.waitUntilEnd();
        return this;
    }
}
