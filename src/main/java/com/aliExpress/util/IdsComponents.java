package aliExpress.util;

import io.fluentlenium.core.FluentPage;
import io.fluentlenium.core.domain.FluentWebElement;
import io.fluentlenium.core.hook.wait.Wait;
import org.openqa.selenium.support.FindBy;

@Wait
public class IdsComponents extends FluentPage {

    @FindBy(css = "span[class='nav-line-2 ']")
    public FluentWebElement accountAndListButton;

    @FindBy(css = "[id='captchacharacters']")
    public FluentWebElement captchaInput;

    @FindBy(css = "button.a-button-text")
    public FluentWebElement continueShoppingButton;



}
