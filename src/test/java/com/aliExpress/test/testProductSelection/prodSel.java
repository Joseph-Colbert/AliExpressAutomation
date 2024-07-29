package com.aliExpress.test.testProductSelection;

import com.aliExpress.productSelection.NavigationProcess;
import com.aliExpress.test.AbstractChomeTest;
import com.aliExpress.test.AbstractGeckoDriver;
import io.fluentlenium.configuration.FluentConfiguration;
import io.fluentlenium.core.annotation.Page;
import io.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;

@FluentConfiguration(capabilities = "{\"goog:chromeOptions\": {\"args\": [\"headless\",\"disable-gpu\"]}}")
@Wait
public class prodSel extends AbstractChomeTest {
    @Page
    public NavigationProcess navigationProcess;

    @Test
    public void aliExpressHomePage() {
        goTo(navigationProcess)
                .selectProduct("Funko Pop")
                .addProduct(400,400)
                .addProductScroll(3, 780, 400)
                .selectOptions("México",110);
    }
}