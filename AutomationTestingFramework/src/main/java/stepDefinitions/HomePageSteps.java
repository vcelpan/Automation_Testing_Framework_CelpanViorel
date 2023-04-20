package stepDefinitions;

import ContextManagers.TestContext;
import pageObjects.HomePage;

public class HomePageSteps {

    private TestContext testContext;
    private HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = new HomePage(testContext.getWebDriverManager().getDriver());
    }
}