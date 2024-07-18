package aliExpress.util;

import io.fluentlenium.core.FluentPage;
import io.fluentlenium.core.annotation.Page;
import io.fluentlenium.core.annotation.PageUrl;

import java.util.concurrent.TimeUnit;

@PageUrl(AliExpressAbstract.URLAMAZON)
public class LoginAliExpress extends FluentPage {
    private static final String SEARCH_FORM_HOMEPAGE = "#search_form_homepage";

    @Page
    public IdsComponents idsComponents;

    public LoginAliExpress login() {
      /*  CookiesUtil.configurarCookieAmazon(this.getDriver());
        idsComponents.captchaInput.write(".");
        idsComponents.continueShoppingButton.click();
        waitUntilTheEnd();
        idsComponents.accountAndListButton.click();*/
        return this;
    }

    /**
     * Se la utiliza para dar tiempo de espera entre operaciones.
     */
    private void waitUntilTheEnd() {
        await().atMost(60, TimeUnit.SECONDS).until(el(SEARCH_FORM_HOMEPAGE)).not().present();
    }
}
