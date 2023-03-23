package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends Page{

    public WishListPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
    private WebElement continueButton;

    public WebElement getContinueButton() {
        return continueButton;
    }
}
