package pageObjects;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page{

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage toPage() {
        driver.get(url);
        return this;
    }
}
