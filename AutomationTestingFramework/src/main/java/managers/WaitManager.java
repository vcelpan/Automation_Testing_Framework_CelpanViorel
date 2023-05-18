package managers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.*;

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
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.error(e);
            throw new TimeoutException(e);
        }
        long endTime = System.currentTimeMillis();

        logger.info("Waited for the element to be clickable: " + (double) (endTime - startTime) / 1000 + " seconds.");
    }

    public static void toBeVisible(WebElement element, WebDriver driver) {
        if (wait == null) new WaitManager(driver);

        long startTime = System.currentTimeMillis();
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.error(e);
            throw new TimeoutException(e);
        }
        long endTime = System.currentTimeMillis();

        logger.info("Waited for the element to be visible: " + (double) (endTime - startTime) / 1000 + " seconds.");
    }

    public static void alertIsPresent(WebDriver driver) {
        if (wait == null) new WaitManager(driver);

        long startTime = System.currentTimeMillis();
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            e.printStackTrace();
            logger.error(e);
            throw new TimeoutException(e);
        }
        long endTime = System.currentTimeMillis();

        logger.info("Waited for the alert to appear: " + (double) (endTime - startTime) / 1000 + " seconds.");

    }
}
