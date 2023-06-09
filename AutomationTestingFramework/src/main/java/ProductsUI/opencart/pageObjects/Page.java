package ProductsUI.opencart.pageObjects;

import Common.managers.TestDataFileReaderManager;

import ProductsUI.opencart.managers.JavaScriptManager;
import ProductsUI.opencart.managers.WaitManager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Page {

    public final WebDriver driver;
    public static final String url = TestDataFileReaderManager.getProperty("url");

    // CurrencyEnum
    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/a/span")
    protected WebElement currencyButton;
    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/ul/li[1]/a")
    protected WebElement euroButton;
    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/ul/li[2]/a")
    protected WebElement poundSterlingButton;
    @FindBy(xpath = "//*[@id=\"form-currency\"]/div/ul/li[3]/a")
    protected WebElement usDollarButton;

    // Phone number
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[1]/span")
    protected WebElement phoneNumberText;

    // My Account
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
    protected WebElement myAccountButton;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    protected WebElement registerButton;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    protected WebElement loginButton;


    // Wish List
    @FindBy(id = "wishlist-total")
    protected WebElement wishListButton;

    // Shopping Cart
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[4]/a/span")
    protected WebElement shoppingCartButton;

    // Checkout
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[5]/a/span")
    protected WebElement checkoutButton;

    // Logo
    @FindBy(id = "logo")
    protected WebElement logoButton;

    // Search bar
    @FindBy(id = "search")
    protected WebElement searchInput;
    @FindBy(xpath = "//*[@id=\"search\"]/button")
    protected WebElement searchButton;

    // Cart info
    @FindBy(xpath = "//*[@id=\"header-cart\"]/div/button")
    protected WebElement cartInfoButton;

    public Page(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public static void navigateToPage(String page, WebDriver driver) {
        Method method;
        try {
            method = Class.forName("ProductsUI.opencart.pageObjects." + page).getMethod("toPage");
            method.invoke(Class.forName("ProductsUI.opencart.pageObjects." + page).getConstructor(WebDriver.class).newInstance(driver));
        } catch (NoSuchMethodException | ClassNotFoundException | IllegalAccessException | InstantiationException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void clickOnElement(Object pageName, String elementName, WebDriver driver) throws InterruptedException {
        WebElement button = getElement(pageName,elementName,driver);
        WaitManager.toBeClickable(button, driver);

        try{
            button.click();
        } catch (ElementNotInteractableException e){
            JavaScriptManager.scrollToElement(button, driver);
            button.click();
        }
    }

    public static boolean elementIsDisplayed(Object pageName, String elementName, WebDriver driver){
        return getElement(pageName,elementName,driver).isDisplayed();
    }

    public static WebElement getElement(Object pageName, String elementName, WebDriver driver) {
        WebElement webElement = null;

        Class clazz = null;
        try {
            clazz = Class.forName("ProductsUI.opencart.pageObjects." + pageName.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Field field = null;
        try {
            field = clazz.getDeclaredField(elementName);
        } catch (NoSuchFieldException e) {
            Class superClass = clazz.getSuperclass();
            try {
                field = superClass.getDeclaredField(elementName);
            } catch (NoSuchFieldException err) {
                err.printStackTrace();
            }
        } finally {
            field.setAccessible(true);
            try {
                webElement = (WebElement) field.get(clazz.getConstructor(WebDriver.class).newInstance(driver));
                WaitManager.toBeVisible(webElement, driver);
            } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                     InvocationTargetException | SecurityException e) {
                e.printStackTrace();
            }
        }
        if (webElement == null) throw new RuntimeException("No such element on the page");

        return webElement;
    }

    public static WebElement findElementByText(String text, WebDriver driver) {
        WebElement webElement = null;
        try {
            webElement = driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
            WaitManager.toBeVisible(webElement, driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (webElement == null) throw new RuntimeException("No such element on the page");

        return webElement;
    }
}
