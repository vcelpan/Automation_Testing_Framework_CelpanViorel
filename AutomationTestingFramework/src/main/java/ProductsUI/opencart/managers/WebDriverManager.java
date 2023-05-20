package ProductsUI.opencart.managers;

import Common.managers.TestDataFileReaderManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class WebDriverManager {

    private WebDriver driver;
    private final String webDriverType;

    private static final Logger logger = LogManager.getLogger(WebDriverManager.class);

    public WebDriverManager() {
        webDriverType = TestDataFileReaderManager.getProperty("browserType");
    }

    private void createDriver() {
        switch (webDriverType) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/webdrivers/Windows/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/webdrivers/macOS/geckodriver");
                FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver(options);
                break;
            default:
                String message = "You don't have such configuration for webDriverType - " + webDriverType;
                logger.error(message);
                throw new RuntimeException(message);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
    }

    public WebDriver getDriver() {
        if (driver == null) createDriver();
        return driver;
    }
}
