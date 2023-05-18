package stepDefinitions;

import ContextManagers.ContextKeys;
import ContextManagers.TestContext;
import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.Page;

import java.util.List;

public class GeneralSteps {

    private final TestContext testContext;

    private static final Logger logger = LogManager.getLogger(GeneralSteps.class);

    public GeneralSteps(TestContext context) {
        testContext = context;
    }

    @Given("^\"([^\"]*)\" is opened$")
    public void isOpened(String page) {
        Page.navigateToPage(page, testContext.getWebDriverManager().getDriver());
        logger.info(page + " is opened");
        testContext.getScenarioContext().setContext(ContextKeys.PAGE, page);

        boolean verdict = testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(Page.url);
        Assertions.assertTrue(verdict, "The url contains: " + Page.url);
    }

    @Then("^\"([^\"]*)\" is the new page opened$")
    public void isTheNewPageOpened(String page) {
        testContext.getScenarioContext().setContext(ContextKeys.PAGE, page);
        logger.info(page + " is opened");

        boolean verdict = testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(Page.url);
        Assertions.assertTrue(verdict, "The url contains: " + Page.url);
    }

    @When("^\"([^\"]*)\" button is clicked$")
    public void buttonIsClicked(String button) throws InterruptedException {
        Page.clickOnElement(testContext.getScenarioContext().getContext(ContextKeys.PAGE), button, testContext.getWebDriverManager().getDriver());
        logger.info(button + " is clicked");
    }

    @Then("^\"([^\"]*)\" is displayed$")
    public void isDisplayed(String button) {
        boolean verdict = Page.elementIsDisplayed(testContext.getScenarioContext().getContext(ContextKeys.PAGE), button, testContext.getWebDriverManager().getDriver());
        logger.info(button + " is displayed: " + verdict);
        Assertions.assertTrue(verdict, "The button is displayed.");
    }

    @Then("^the new url contains the following string \"([^\"]*)\"$")
    public void theNewUrlContainsTheFollowingString(String contentKey) {
        boolean verdict = testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(contentKey);
        Assertions.assertTrue(verdict, "The url contains: " + contentKey);
    }

    @Then("^the following errors (are|are not) displayed on the screen:$")
    public void theFollowingErrorsAreDisplayedOnTheScreen(String condition, List<String> errorMessages) {
        for (String errorMessage : errorMessages) {
            boolean elementIsDisplayed = false;
            try {
                WebElement webElement = testContext.getWebDriverManager().getDriver().
                        findElement(By.xpath("//*[contains(text(),'" + errorMessage + "')]]"));
                elementIsDisplayed = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (condition.contains("are not"))
                Assert.assertFalse("The error message is not displayed.", elementIsDisplayed);
            else {
                Assert.assertTrue("The error message is displayed.", elementIsDisplayed);
            }
        }
    }
}
