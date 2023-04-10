package stepDefinitions;

import ContextManagers.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pageObjects.RegisterPage;

import java.util.Map;

public class RegisterPageSteps {

    private TestContext testContext;
    private RegisterPage registerPage;

    public RegisterPageSteps(TestContext context){
        testContext = context;
        registerPage = new RegisterPage(testContext.getWebDriverManager().getDriver());
    }

    @When("^the registration form is populated with below data:$")
    public void theRegistrationFormIsPopulatedWithBelowData(Map<String, String> formData) {
        String firstName = formData.get("firstName");
        String lastName = formData.get("lastName");
        String email = formData.get("email");
        String password = formData.get("password");
        registerPage.fillInRegisterForm(firstName, lastName, email, password, true);
    }

//    @And("^privacy button is clicked$")
//    public void privacyButtonIsClicked() {
//        registerPage.getPrivacyCheckBox().click();
//    }
//
//    @And("^continue button is clicked$")
//    public void continueButtonIsClicked() {
//        registerPage.getContinueButton().click();
//    }
}
