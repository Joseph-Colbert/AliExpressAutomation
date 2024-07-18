package aliExpress.util;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.sun.activation.registries.LogSupport.log;

/**
 * Contiene el método para poder saltarnos el captcha
 */
public class CookiesUtil {

    private static final Logger log = LoggerFactory.getLogger(CookiesUtil.class);

    /**
     * Método donde tenemos el webdriver, utilizado para evitar la anotación del captcha
     * al iniciar sesion
     */
    public static void configurarCookieAmazon(WebDriver driver){
        try{
            Cookie ck = new Cookie("AMAZON_DEV_NO_CAPTCHA", "true");

            Cookie cookie = driver.manage().getCookieNamed("AMAZON_DEV_NO_CAPTCHA");
            if (cookie == null) {
                driver.manage().addCookie(ck);
                log("Se añadió la cookie Amazon correctamente");
            }else {
                log("Se encontró la Cookie Amazon");
            }
        }catch(Exception e){
            log("Error al configurar Cookie Amazon "+ e);
        }
    }

}
