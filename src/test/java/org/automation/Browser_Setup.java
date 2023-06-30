package org.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Browser_Setup {
    private WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);


    }

    public WebDriver getDriver() {
        return driver;
    }

    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}