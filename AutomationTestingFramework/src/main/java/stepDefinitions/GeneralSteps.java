package stepDefinitions;

import ContextManagers.TestContext;
import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GeneralSteps {

    private TestContext testContext;

    public GeneralSteps(TestContext context) {
        testContext = context;
    }

    @Given("^\"([^\"]*)\" is accessed$")
    public void isAccessed(String link) {
        testContext.getWebDriverManager().getDriver().get(link);
        Assertions.assertTrue(testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(link),
                "The full link is accessed as specified: " + link);
    }

    @Then("^the new url contains the following string \"([^\"]*)\"$")
    public void theNewUrlContainsTheFollowingString(String contentKey){
        boolean stringIsPresentInUrl = testContext.getWebDriverManager().getDriver().getCurrentUrl().contains(contentKey);
        Assertions.assertTrue(stringIsPresentInUrl, "The url contains: " + contentKey);
    }

    @Then("^the following errors (are|are not) displayed on the screen:$")
    public void theFollowingErrorsAreDisplayedOnTheScreen(String condition, List<String> errorMessages) {
        for (int i=0; i<errorMessages.size(); i++){
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
            else{
                Assert.assertTrue("The error message is displayed.", elementIsDisplayed);
            }
        }
    }
}
