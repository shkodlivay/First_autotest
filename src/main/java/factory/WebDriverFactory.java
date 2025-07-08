package factory;

import exceptions.BrowserNotSupportedException;
import factory.settings.ChromeSettings;
import factory.settings.HeadlessChromeSettings;
import factory.settings.KioskChromeSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    private static final String browserName = System.getProperty("browser");

    public static WebDriver getDriver(String mode) {
        if (browserName.equalsIgnoreCase("chrome")) {
            switch (mode) {
                case "fullscreen" -> {
                    return new ChromeDriver((ChromeOptions) new ChromeSettings().settings());
                }
                case "headless" -> {
                    return new ChromeDriver((ChromeOptions) new HeadlessChromeSettings().settings());
                }
                case "kiosk" -> {
                    return new ChromeDriver((ChromeOptions) new KioskChromeSettings().settings());
                }
            }
        }

        throw new BrowserNotSupportedException(browserName);
    }

}
