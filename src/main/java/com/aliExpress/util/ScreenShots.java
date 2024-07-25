package com.aliExpress.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

/**
 * Contiene el método para capturar pantalla.
 */
public class ScreenShots {
    /**
     * Método en el cual se almacena el nombre de la captura de pantalla, la dirección donde sera
     * almacenada y el webdriver.
     */
    public static void takeScreenShot(String nameScreenShot, String address, WebDriver driver) {
        TakesScreenshot screenshotTaker = (TakesScreenshot) driver;
        File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File(address + nameScreenShot + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}