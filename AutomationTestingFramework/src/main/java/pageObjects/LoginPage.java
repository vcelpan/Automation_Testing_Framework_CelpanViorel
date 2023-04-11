package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{

    private static final String endpoint = "/index.php?route=account/login";

    @FindBy(id = "input-email")
    private WebElement emailInput;
    @FindBy(id = "input-password")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"form-login\"]/div[2]/a")
    private WebElement forgotPasswordButton;
    @FindBy(xpath = "//*[@id=\"form-login\"]/button")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public LoginPage toPage() {
        driver.get(url + endpoint);
        return this;
    }

    public void fillInLoginForm(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }
}
