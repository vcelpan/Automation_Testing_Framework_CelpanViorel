package pageObjects;

import managers.TestDataFileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CurrencyEnum;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Page {

    public final WebDriver driver;
    public static final String url = TestDataFileReaderManager.getApplicationUrl();

    public Page(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public static void navigateToPage(String page, WebDriver driver) {
        Method method;
        try {
            method = Class.forName("pageObjects." + page).getMethod("toPage");
            method.invoke(Class.forName("pageObjects." + page).getConstructor(WebDriver.class).newInstance(driver));
        } catch (NoSuchMethodException | ClassNotFoundException | IllegalAccessException | InstantiationException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void clickOnElement(Object pageName, String elementName, WebDriver driver){
        getElement(pageName,elementName,driver).click();
    }

    public static boolean elementIsDisplayed(Object pageName, String elementName, WebDriver driver){
        return getElement(pageName,elementName,driver).isDisplayed();
    }

    public static WebElement getElement(Object pageName, String elementName, WebDriver driver) {
        WebElement webElement = null;

        Class clazz = null;
        try {
            clazz = Class.forName("pageObjects." + pageName.toString());
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
            } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
                     InvocationTargetException | SecurityException e) {
                e.printStackTrace();
            }
        }

//        TODO: Aceasta e partea de cod care nu gasea elementele din clasa parinte
//        Field[] fields = clazz.getDeclaredFields();
//        for (Field field : fields) {
//            if (field.getType() == WebElement.class) {
//                field.setAccessible(true);
//                if (field.getName().equals(elementName))
//                    try {
//                        webElement = (WebElement) field.get(clazz.getConstructor(WebDriver.class).newInstance(driver));
//                        break;
//                    } catch (IllegalAccessException | NoSuchMethodException | InstantiationException |
//                             InvocationTargetException | SecurityException e) {
//                        e.printStackTrace();
//                    }
//            }
//        }
        if (webElement == null) throw new RuntimeException("No such element in page");

        return webElement;
    }

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
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[1]/span")
    protected WebElement phoneNumberText;

    // My Account
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/a/span")
    protected WebElement myAccountButton;
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/ul/li[1]/a")
    protected WebElement registerButton;
    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/ul/li[2]/a")
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

//    public void selectCurrency(CurrencyEnum currency) {
//        currencyButton.click();
//        switch (currency) {
//            case EURO:
//                euroButton.click();
//                break;
//            case POUND:
//                poundSterlingButton.click();
//                break;
//            case DOLLAR:
//                usDollarButton.click();
//                break;
//        }
//    }
//
//    public void clikcOnMyAccountBtn() {
//        myAccountButton.click();
//    }
//
//    public void clickOnRegisterBtn() {
//        registerButton.click();
//    }
//
//    public boolean registerButtonIsDisplayed() {
//        return registerButton.isDisplayed();
//    }
//
//    public void navigateToRegisterPage() {
//        myAccountButton.click();
//        registerButton.click();
//    }
//
//    public void navigateToLoginPage() {
//        myAccountButton.click();
//        loginButton.click();
//    }
}
