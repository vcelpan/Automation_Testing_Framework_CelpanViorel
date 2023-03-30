package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {

    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;
    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;
    @FindBy(id = "input-email")
    private WebElement emailInput;
    @FindBy(id = "input-password")
    private WebElement passwordInput;
    @FindBy(id = "input-newsletter-yes")
    private WebElement subscribeRadioButtonYes;
    @FindBy(id = "input-newsletter-no")
    private WebElement subscribeRadioButtonNo;
    @FindBy(xpath = "//*[@id=\"form-register\"]/div/div/div/input")
    private WebElement privacyCheckBox;
    @FindBy(xpath = "//*[@id=\"form-register\"]/div/div/button")
    private WebElement continueButton;

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getSubscribeRadioButtonYes() {
        return subscribeRadioButtonYes;
    }

    public WebElement getSubscribeRadioButtonNo() {
        return subscribeRadioButtonNo;
    }

    public WebElement getPrivacyCheckBox() {
        return privacyCheckBox;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public void fillInRegisterForm(String firstName, String lastName, String email, String password, boolean subscribe) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        if (subscribe) {
            subscribeRadioButtonYes.click();
        } else {
            subscribeRadioButtonNo.click();
        }

        privacyCheckBox.click();
    }

    public boolean allTheElementsAreDisplayed() {
        return firstNameInput.isDisplayed() && lastNameInput.isDisplayed() && emailInput.isDisplayed() &&
                subscribeRadioButtonYes.isDisplayed() && subscribeRadioButtonNo.isDisplayed() &&
                privacyCheckBox.isDisplayed() && continueButton.isDisplayed();
    }
}
