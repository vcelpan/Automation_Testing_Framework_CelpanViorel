package stepDefinitions;

import ContextManagers.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageObjects.HomePage;

public class HomePageSteps {

    private TestContext testContext;
    private HomePage homePage;

    public HomePageSteps(TestContext context){
        testContext = context;
        homePage = new HomePage(testContext.getWebDriverManager().getDriver());
    }

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String link) {
        testContext.getWebDriverManager().getDriver().get(link);
        testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(link);
    }

    @When("^my account button is clicked$")
    public void myAccountButtonIsClicked() {
        homePage.clikcOnMyAccountBtn();
    }

    @Then("^register account button is displayed$")
    public void registerAccountButtonIsDisplayed() {
        Assertions.assertTrue(homePage.registerButtonIsDisplayed(), "The register account button is displayed.");
    }

    @And("^register account button is clicked$")
    public void registerAccountButtonIsClicked() {
        homePage.clickOnRegisterBtn();
    }

    @Then("^the new url contains the following string \"([^\"]*)\"$")
    public void theNewUrlContainsTheFollowingString(String contentKey) throws Throwable {
        boolean stringIsPresentInUrl = testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(contentKey);
        Assertions.assertTrue(stringIsPresentInUrl, "The url contains: " + contentKey);
    }
}
