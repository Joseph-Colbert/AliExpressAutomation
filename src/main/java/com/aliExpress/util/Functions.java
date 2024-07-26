package com.aliExpress.util;

import io.fluentlenium.core.FluentPage;
import io.fluentlenium.core.hook.wait.Wait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Wait
public class Functions extends FluentPage {

    private static final String SEARCH_FORM_HOMEPAGE = "#search_form_homepage";

    /**
     * Método para crear un puntero utilizando JavaScript
     * @return Page Functions
     */
    public Functions pointer(int xOffset, int yOffset) {
        // Agregar un marcador visual con JavaScript
        executeScript(
                "var elem = document.createElement('div');" +
                        "elem.id = 'mouse-marker';" +
                        "elem.style.position = 'fixed';" + // Cambiado a 'fixed' para probar
                        "elem.style.width = '10px';" +
                        "elem.style.height = '10px';" +
                        "elem.style.backgroundColor = '#FF00FF';" +
                        "elem.style.borderRadius = '50%';" +
                        "elem.style.zIndex = '10000';" +
                        "document.body.appendChild(elem);" +
                        "elem.style.left = arguments[0] + 'px';" +
                        "elem.style.top = arguments[1] + 'px';",
                xOffset, yOffset
        );

        // Esperar un poco para visualizar el marcador
        try {
            Thread.sleep(1000); // Esperar 1 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }


    /**
     * Método para quitar el puntero creado
     * @return Page Functions
     */
    public Functions removePointer() {
        // Quitar el marcador visual después del clic
        executeScript(
                "var elem = document.getElementById('mouse-marker');" +
                        "if (elem) { elem.parentNode.removeChild(elem); }"
        );
        return this;
    }

    public Functions changePage() {
        // Guardar el handle (identificador único) de la ventana actual
        String originalWindow = getDriver().getWindowHandle();
        // Obtén todos los handles de las ventanas
        Set<String> windowHandles = getDriver().getWindowHandles();
        // Cambia el foco a la nueva ventana
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindow)) {
                // Cambia el foco a la nueva ventana
                getDriver().switchTo().window(windowHandle);
                // Cierra la ventana original
                getDriver().switchTo().window(originalWindow).close();
                // Vuelve a cambiar el foco a la nueva ventana, si es necesario
                getDriver().switchTo().window(windowHandle);
                break;// para salir luego de encontrar la intruccion
            }
        }
        return this;
    }

    /*public Functions changePage() {
        // Guardar el handle(identificador unico que diferencia las pestañas que utiliza Webdriver) de la ventana actual
        String originalWindow = getDriver().getWindowHandle();
        // Obtén todos los handles de las ventanas
        Set<String> windowHandles = getDriver().getWindowHandles();
        // Cambia el foco a la nueva ventana
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindow)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        // Si se desea volver a la ventana original
        //getDriver().switchTo().window(originalWindow);
        return this;
    }*/

    /**
     * Se la utiliza para dar tiempo de espera entre operaciones.
     */
    public void waitUntilEnd() {
        await().atMost(60, TimeUnit.SECONDS).until(el(SEARCH_FORM_HOMEPAGE)).not().present();
    }
}
