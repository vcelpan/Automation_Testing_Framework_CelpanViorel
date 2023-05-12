package managers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.*;
import java.util.concurrent.TimeUnit;

public class WaitManager {
    private static WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(WaitManager.class);

    public WaitManager(WebDriver driver) {
        logger.info("Setting up the explicit WaitManager.");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofSeconds(2));
    }

    public static void toBeClickable(WebElement element, WebDriver driver) {
        if (wait == null) new WaitManager(driver);

        long startTime = System.currentTimeMillis();
        wait.until(ExpectedConditions.elementToBeClickable(element));
        long endTime = System.currentTimeMillis();
        logger.info("Waited for the element to be clickable: " + (double)(endTime - startTime)/1000 + " seconds.");
    }

    public static void toBeVisible(WebElement element, WebDriver driver) {
        if (wait == null) new WaitManager(driver);

        long startTime = System.currentTimeMillis();
        wait.until(ExpectedConditions.visibilityOf(element));
        long endTime = System.currentTimeMillis();
        logger.info("Waited for the element to be visible: " + (double)(endTime - startTime)/1000 + " seconds.");
    }
}
