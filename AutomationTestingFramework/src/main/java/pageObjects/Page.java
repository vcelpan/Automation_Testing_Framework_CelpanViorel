package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CurrencyEnum;

public abstract class Page {

    public Page(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    // CurrencyEnum
    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/a/span")
    private WebElement currencyButton;
    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/ul/li[1]/a")
    private WebElement euroButton;
    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/ul/li[2]/a")
    private WebElement poundSterlingButton;
    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/ul/li[3]/a")
    private WebElement usDollarButton;

    // Phone number
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[1]/span")
    private WebElement phoneNumberText;

    // My Account
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/a/span")
    private WebElement myAccountButton;
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/ul/li[1]/a")
    private WebElement registerButton;
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/ul/li[2]/a")
    private WebElement loginButton;


    // Wish List
    @FindBy(id = "wishlist-total")
    private WebElement wishListButton;

    // Shopping Cart
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[4]/a/span")
    private WebElement shoppingCartButton;

    // Checkout
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[5]/a/span")
    private WebElement checkoutButton;

    // Logo
    @FindBy(id = "logo")
    private WebElement logoButton;

    // Search bar
    @FindBy(id = "search")
    private WebElement searchInput;
    @FindBy(xpath = "//*[@id=\"search\"]/button")
    private WebElement searchButton;

    // Cart info
    @FindBy(xpath = "//*[@id=\"header-cart\"]/div/button")
    private WebElement cartInfoButton;

    public WebElement getCurrencyButton() {
        return currencyButton;
    }

    public WebElement getEuroButton() {
        return euroButton;
    }

    public WebElement getPoundSterlingButton() {
        return poundSterlingButton;
    }

    public WebElement getUsDollarButton() {
        return usDollarButton;
    }

    public WebElement getPhoneNumberText() {
        return phoneNumberText;
    }

    public WebElement getMyAccountButton() {
        return myAccountButton;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getWishListButton() {
        return wishListButton;
    }

    public WebElement getShoppingCartButton() {
        return shoppingCartButton;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public WebElement getLogoButton() {
        return logoButton;
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getCartInfoButton() {
        return cartInfoButton;
    }

    public void selectCurrency(CurrencyEnum currency){
        currencyButton.click();
        switch (currency){
            case EURO:
                euroButton.click();
                break;
            case POUND:
                poundSterlingButton.click();
                break;
            case DOLLAR:
                usDollarButton.click();
                break;
        }
    }

    public void clikcOnMyAccountBtn(){
        myAccountButton.click();
    }

    public void clickOnRegisterBtn(){
        registerButton.click();
    }

    public boolean registerButtonIsDisplayed(){
        return registerButton.isDisplayed();
    }

    public void navigateToRegisterPage(){
        myAccountButton.click();
        registerButton.click();
    }

    public void navigateToLoginPage(){
        myAccountButton.click();
        loginButton.click();
    }
}
