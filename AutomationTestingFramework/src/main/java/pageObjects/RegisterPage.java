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
    @FindBy(id = "input-telephone")
    private WebElement telephoneInput;
    @FindBy(id = "input-password")
    private WebElement passwordInput;
    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmInput;
    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")
    private WebElement subscribeRadioButtonYes;
    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input")
    private WebElement subscribeRadioButtonNo;
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
    private WebElement privacyCheckBox;
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    private WebElement continueButton;

    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }

    public RegisterPage toPage() {
        driver.get(url + endpoint);
        return this;
    }
}
