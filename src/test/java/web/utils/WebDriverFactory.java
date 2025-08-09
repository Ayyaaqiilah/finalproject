package web.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

    public static WebDriver createChrome(boolean headless) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        if (headless) {
            // new headless mode works for modern chrome
            options.addArguments("--headless=new");
        }

        return new ChromeDriver(options);
    }
}
