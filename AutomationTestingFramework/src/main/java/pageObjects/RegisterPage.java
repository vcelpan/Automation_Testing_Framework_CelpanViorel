package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {

    private static final String endpoint = "/index.php?route=account/register";

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

    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public RegisterPage toPage() {
        driver.get(url + endpoint);
        return this;
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
