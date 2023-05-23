package ProductsUI.opencart.managers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptManager {

    private static final Logger logger = LogManager.getLogger(JavaScriptManager.class);

    public static void scrollToElement(WebElement element, WebDriver driver) throws InterruptedException {
        logger.info("Scrolling to the element: " + element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
    }
}
