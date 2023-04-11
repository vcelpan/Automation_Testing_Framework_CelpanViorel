package stepDefinitions;

import ContextManagers.ContextKeys;
import ContextManagers.TestContext;
import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.Page;

import java.util.List;

public class GeneralSteps {

    private TestContext testContext;

    public GeneralSteps(TestContext context) {
        testContext = context;
    }

    @Given("^\"([^\"]*)\" is opened$")
    public void isOpened(String page) {
        Page.navigateToPage(page, testContext.getWebDriverManager().getDriver());
        testContext.getScenarioContext().setContext(ContextKeys.PAGE, page);

        boolean verdict = testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(Page.url);
        Assertions.assertTrue(verdict, "The url contains: " + Page.url);
    }

    @When("^\"([^\"]*)\" button is clicked$")
    public void buttonIsClicked(String button) {
        Page.clickOnElement(testContext.getScenarioContext().getContext(ContextKeys.PAGE), button, testContext.getWebDriverManager().getDriver());
        System.out.println("The button is clicked: " + button);
    }

    @Then("^\"([^\"]*)\" is displayed$")
    public void isDisplayed(String button) {
        boolean verdict = Page.elementIsDisplayed(testContext.getScenarioContext().getContext(ContextKeys.PAGE), button, testContext.getWebDriverManager().getDriver());
        Assertions.assertTrue(verdict, "The button is displayed.");
    }

    @Then("^the new url contains the following string \"([^\"]*)\"$")
    public void theNewUrlContainsTheFollowingString(String contentKey) {
        boolean verdict = testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(contentKey);
        Assertions.assertTrue(verdict, "The url contains: " + contentKey);
    }

    @Then("^the following errors (are|are not) displayed on the screen:$")
    public void theFollowingErrorsAreDisplayedOnTheScreen(String condition, List<String> errorMessages) {
        for (int i = 0; i < errorMessages.size(); i++) {
            boolean elementIsDisplayed = false;
            try {
                WebElement webElement = testContext.getWebDriverManager().getDriver().
                        findElement(By.xpath("//*[contains(text(),'" + errorMessages.get(i) + "')]]"));
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