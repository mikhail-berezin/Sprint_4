package factory;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory extends ExternalResource {

    private final WebDriver driver;

    public DriverFactory(String browserName) {
        if ("firefox".equals(browserName)) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
    }

    @Override
    protected void after()  {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
