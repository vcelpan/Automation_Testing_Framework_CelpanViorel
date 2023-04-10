import managers.WebDriverManager;
import org.junit.jupiter.api.*;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import utils.CurrencyEnum;

public class JunitPractice {

    WebDriverManager webDriverManager = new WebDriverManager();

    @BeforeEach
    public void beforeTestProcedure(){
        webDriverManager.getDriver().get("https://demo.opencart.com/");
    }

    @AfterEach
    public void afterTestInstructions(){
        webDriverManager.closeDriver();
    }

    @Test
    @DisplayName("Adresa URL a paginii Register este disponibila din pagina Home")
    public void verifyTheRegisterPageIsAccessible() throws InterruptedException {
        HomePage homePage = new HomePage(webDriverManager.getDriver());
        homePage.navigateToRegisterPage();

        boolean urlIsValid = webDriverManager.getDriver().getCurrentUrl().contains("register");
        Assertions.assertTrue(urlIsValid, "Adresa URL nu este valida");
    }

    @Test
    @DisplayName("Register page elements are displayed")
    public void registerPageElementsAreDisplayed(){
        HomePage homePage = new HomePage(webDriverManager.getDriver());
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(webDriverManager.getDriver());
        Assertions.assertTrue(registerPage.allTheElementsAreDisplayed(), "Cel putin unul dintre elemente nu a fost afisat.");
    }
}
