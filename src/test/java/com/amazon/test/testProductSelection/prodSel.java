package com.amazon.test.testProductSelection;

import amazon.util.LoginAmazon;
import com.amazon.test.AbstractChomeTest;
import io.fluentlenium.configuration.FluentConfiguration;
import io.fluentlenium.core.annotation.Page;
import io.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;

@FluentConfiguration(capabilities = "{\"goog:chromeOptions\": {\"args\": [\"headless\",\"disable-gpu\"]}}")
@Wait
public class prodSel extends AbstractChomeTest {
    @Page
    LoginAmazon loginAmazon;

    @Test
    public void amazonHomePage() {
        goTo(loginAmazon);

    }
}
