package main;

import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseSuite {
    protected WebDriver driver;

    @BeforeEach
    public void init() {
        driver = WebDriverFactory.getDriver("fullscreen");
    }

    @AfterEach
    public void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}