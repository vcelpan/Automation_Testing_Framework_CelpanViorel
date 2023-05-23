package ProductsUI.opencart.stepDefinitions;

import ProductsUI.opencart.ContextManagers.TestContext;
import ProductsUI.opencart.pageObjects.HomePage;

public class HomePageSteps {

    private TestContext testContext;
    private HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = new HomePage(testContext.getWebDriverManager().getDriver());
    }
}