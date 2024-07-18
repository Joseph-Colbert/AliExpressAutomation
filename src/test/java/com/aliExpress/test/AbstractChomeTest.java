package com.aliExpress.test;

import io.fluentlenium.adapter.junit.FluentTest;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.ExecutableFinder;

public class AbstractChomeTest extends FluentTest {
    private static final String PATH_TO_CHROME_DRIVER = "src/main/resources/driver/chromedriver.exe";
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    @BeforeClass
    public static void setup() {
        if (systemPropertyNotSet() && executableNotPresentInPath()) {
            setSystemProperty();
        }
    }

    private static boolean executableNotPresentInPath() {
        return new ExecutableFinder().find("chromedriver") == null;
    }

    private static boolean systemPropertyNotSet() {
        return System.getProperty(CHROME_DRIVER_PROPERTY) == null;
    }

    private static void setSystemProperty() {
        System.setProperty(CHROME_DRIVER_PROPERTY, PATH_TO_CHROME_DRIVER);
    }

    @Override
    public WebDriver newWebDriver() {
        return new ChromeDriver();
    }
}
