package ProductsAPI.petstore.stepDefinitions;

import ProductsAPI.petstore.ContextManagers.ContextKeys;
import ProductsAPI.petstore.ContextManagers.TestContext;
import ProductsAPI.petstore.utils.RestEndpoint;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Assert;

import org.json.JSONObject;

import java.util.Map;

public class GeneralSteps {

    private final TestContext testContext;

    private static final Logger logger = LogManager.getLogger(GeneralSteps.class);

    public GeneralSteps(TestContext context) {
        testContext = context;
    }

    @Given("^user sends a \"([^\"]*)\" request to \"([^\"]*)\" endpoint with following data object$")
    public void userSendsARequestToEndpointWithFollowingDataObject(Method method, RestEndpoint endpoint, Map<String, String> data) {
        RequestSpecification specification = testContext.getRestManager().getRequestSpecification();
        testContext.getScenarioContext().setContext(ContextKeys.REQUEST_SPEC, specification);

        logger.info(String.format("A '%s' request to '%s' endpoint", method, endpoint));
        logger.info(String.format("Request body: \n%s", new JSONObject(data).toString(4)));

        Response response = specification.body(data).request(method, endpoint.getEndpoint());
        logger.info(String.format("Response body: \n%s",  response.getBody().prettyPrint()));
        testContext.getScenarioContext().setContext(ContextKeys.RESPONSE, response);
    }

    @Given("^user sends a \"([^\"]*)\" request to \"([^\"]*)\" endpoint with \"([^\"]*)\" value for \"([^\"]*)\" path variable$")
    public void userSendsARequestToEndpointWithValueForPathVariable(Method method, RestEndpoint endpoint, String variable, String pathVarName) {
        RequestSpecification specification = testContext.getRestManager().getRequestSpecification();
        testContext.getScenarioContext().setContext(ContextKeys.REQUEST_SPEC, specification);

        String endPointUpdated = endpoint.getEndpoint().replace(String.format("{%s}", pathVarName), variable);
        logger.info(String.format("A '%s' request to '%s' endpoint", method, endPointUpdated));

        Response response = specification.request(method, endPointUpdated);
        logger.info(String.format("Response body: \n%s",  response.getBody().prettyPrint()));
        testContext.getScenarioContext().setContext(ContextKeys.RESPONSE, response);
    }

    @Then("^the response code is \"([^\"]*)\"$")
    public void theResponseCodeIs(Integer expectedResponseCode) {
        Response response = (Response) testContext.getScenarioContext().getContext(ContextKeys.RESPONSE);

        String message = "Status code is ";
        try {
            response.then().statusCode(expectedResponseCode);
            logger.info(message + expectedResponseCode);
        } catch (AssertionError exception) {
            logger.error(exception.getMessage());
            throw exception;
        }
    }

    @Then("^the response contains \"([^\"]*)\"$")
    public void theResponseContains(String expectedString) {
        Response response = (Response) testContext.getScenarioContext().getContext(ContextKeys.RESPONSE);

        String message = String.format("Body matches string: '%s'", expectedString);
        try {
            Assert.assertTrue(message, response.getBody().asString().contains(expectedString));
            logger.info(message);
        } catch (AssertionError exception) {
            logger.error(exception.getMessage());
            throw exception;
        }
    }

    @Given("^user sends a \"([^\"]*)\" request to \"([^\"]*)\" endpoint with \"([^\"]*)\" value for \"([^\"]*)\" path variable with the following data object$")
    public void userSendsARequestToEndpointWithValueForPathVariableWithTheFollowingDataObject(Method method, RestEndpoint endpoint, String variable, String pathVarName, Map<String, String> data) {
        RequestSpecification specification = testContext.getRestManager().getRequestSpecification();
        testContext.getScenarioContext().setContext(ContextKeys.REQUEST_SPEC, specification);

        String endPointUpdated = endpoint.getEndpoint().replace(String.format("{%s}", pathVarName), variable);
        Response response = specification.body(data).request(method, endPointUpdated);
        response.getBody().prettyPrint();
        testContext.getScenarioContext().setContext(ContextKeys.RESPONSE, response);
    }
}
