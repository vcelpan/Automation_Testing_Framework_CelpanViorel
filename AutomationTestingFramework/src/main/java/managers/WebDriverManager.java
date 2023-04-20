package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private WebDriver driver;
    private String webDriverType;

    public WebDriverManager(){
        webDriverType = TestDataFileReaderManager.getBrowserType();
    }

    private WebDriver createDriver(){
        switch (webDriverType){
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/macOS/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/macOS/geckodriver");
                FirefoxOptions options = new FirefoxOptions();
                driver = new FirefoxDriver(options);
                break;
            default:
                String message = "You don't have such configuration for webDriverType - " + webDriverType;
                LoggerManager.logConfig(message);
                throw new RuntimeException(message);
        }

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        return driver;
    }

    public WebDriver getDriver() {
        if (driver == null){
            createDriver();
        }

        return driver;
    }

    public void closeDriver(){
        if (driver != null){
            driver.close();
            LoggerManager.logInfo("Webdriverul a fost inchis!");
        }
    }
}
