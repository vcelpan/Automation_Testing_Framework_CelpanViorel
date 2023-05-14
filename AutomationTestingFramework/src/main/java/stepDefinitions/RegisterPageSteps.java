package stepDefinitions;

import ContextManagers.ContextKeys;
import ContextManagers.TestContext;
import cucumber.api.java.en.When;
import pageObjects.Page;
import pageObjects.RegisterPage;

import java.util.Map;

public class RegisterPageSteps {

    private final TestContext testContext;
    private final RegisterPage registerPage;

    public RegisterPageSteps(TestContext context){
        testContext = context;
        registerPage = new RegisterPage(testContext.getWebDriverManager().getDriver());
    }

    @When("^the registration form is populated with below data:$")
    public void theRegistrationFormIsPopulatedWithBelowData(Map<String, String> formData) {
        String firstName = formData.get("firstName");
        String lastName = formData.get("lastName");
        String email = formData.get("email");
        String telephone = formData.get("telephone");
        String password = formData.get("password");
        String passwordConfirm = formData.get("passwordConfirm");

        Page.getElement(testContext.getScenarioContext().getContext(ContextKeys.PAGE), "firstNameInput", testContext.getWebDriverManager().getDriver()).sendKeys(firstName);
        Page.getElement(testContext.getScenarioContext().getContext(ContextKeys.PAGE), "lastNameInput", testContext.getWebDriverManager().getDriver()).sendKeys(lastName);
        Page.getElement(testContext.getScenarioContext().getContext(ContextKeys.PAGE), "emailInput", testContext.getWebDriverManager().getDriver()).sendKeys(email);
        Page.getElement(testContext.getScenarioContext().getContext(ContextKeys.PAGE), "telephoneInput", testContext.getWebDriverManager().getDriver()).sendKeys(telephone);
        Page.getElement(testContext.getScenarioContext().getContext(ContextKeys.PAGE), "passwordInput", testContext.getWebDriverManager().getDriver()).sendKeys(password);
        Page.getElement(testContext.getScenarioContext().getContext(ContextKeys.PAGE), "passwordConfirmInput", testContext.getWebDriverManager().getDriver()).sendKeys(passwordConfirm);
    }
}