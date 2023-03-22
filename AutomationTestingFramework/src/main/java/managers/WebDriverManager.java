package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class WebDriverManager {

    public WebDriverManager(String webDriverType){
        this.webDriverType = webDriverType;
    }

    private WebDriver driver;
    private String webDriverType;

    private WebDriver createDriver(){
        switch (webDriverType){
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe")));
                driver = new FirefoxDriver(options);
                break;
            default:
                System.out.println("Optiunea de web driver indicate nu este valabila. Mai incercati!");
        }
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
            System.out.println("Webdriverul a fost inchis!");
        }
    }
}
