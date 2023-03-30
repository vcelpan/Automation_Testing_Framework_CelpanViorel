package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page{

    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    @FindBy(id = "input-email")
    private WebElement emailInput;
    @FindBy(id = "input-password")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"form-login\"]/div[2]/a")
    private WebElement forgotPasswordButton;
    @FindBy(xpath = "//*[@id=\"form-login\"]/button")
    private WebElement loginButton;

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getForgotPasswordButton() {
        return forgotPasswordButton;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void fillInLoginForm(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }
}
