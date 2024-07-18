package com.aliExpress.test.testProductSelection;

import aliExpress.util.LoginAliExpress;
import com.aliExpress.test.AbstractChomeTest;
import io.fluentlenium.configuration.FluentConfiguration;
import io.fluentlenium.core.annotation.Page;
import io.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;

@FluentConfiguration(capabilities = "{\"goog:chromeOptions\": {\"args\": [\"headless\",\"disable-gpu\"]}}")
@Wait
public class prodSel extends AbstractChomeTest {
    @Page
    LoginAliExpress loginAliExpress;

    @Test
    public void amazonHomePage() {
        goTo(loginAliExpress)
                .login();

    }
}
