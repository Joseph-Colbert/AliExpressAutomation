package com.aliExpress.test;

import io.fluentlenium.adapter.junit.FluentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Clase creada para ejecutar la automatización en firefox.
 */
public abstract class AbstractGeckoDriver extends FluentTest {
    @BeforeClass
    public static void setup() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Override
    public WebDriver newWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        return new FirefoxDriver(options);
    }

}