package stepDefinitions;

import ContextManagers.ContextKeys;
import ContextManagers.TestContext;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import utils.RestEndpoint;

import java.util.Map;

public class RestSteps {

    private final TestContext testContext;

    private static final Logger logger = LogManager.getLogger(RestSteps.class);

    public RestSteps(TestContext context) {
        testContext = context;
    }

    @Given("^user sends a \"([^\"]*)\" request to \"([^\"]*)\" endpoint with following data object$")
    public void userSendsARequestToEndpointWithFollowingDataObject(Method method, RestEndpoint endpoint, Map<String, String> data) {
        RequestSpecification specification = testContext.getRestManager().getRequestSpecification();
        testContext.getScenarioContext().setContext(ContextKeys.REQUEST_SPEC, specification);

        Response response = specification.body(data).request(method, endpoint.getEndpoint());
        response.getBody().prettyPrint();
        testContext.getScenarioContext().setContext(ContextKeys.RESPONSE, response);
    }

//    @Given("^user sends a \"([^\"]*)\" request to \"([^\"]*)\" endpoint with \"([^\"]*)\" value$")
//    public void userSendsARequestToEndpointWithValue(Method method, RestEndpoint endpoint, String variable)  {
//        RequestSpecification specification = testContext.getRestManager().getRequestSpecification();
//        testContext.getScenarioContext().setContext(ContextKeys.REQUEST_SPEC, specification);
////        Response response = specification.request(method, endpoint.getEndpoint().replaceAll(String.format("{%s}", pathVarName), variable));
//        String endPointUpdated = endpoint.getEndpoint().replaceAll("var", variable);
//        String endPointUpdated1 = endpoint.getEndpoint().replaceAll(String.format("{%s}", pathVarName), variable);
//        Response response = specification.request(method, endPointUpdated);
//        response.getBody().prettyPrint();
//        testContext.getScenarioContext().setContext(ContextKeys.RESPONSE, response);
//    }

    @Given("^user sends a \"([^\"]*)\" request to \"([^\"]*)\" endpoint with \"([^\"]*)\" value for \"([^\"]*)\" path variable$")
    public void userSendsARequestToEndpointWithValueForPathVariable(Method method, RestEndpoint endpoint, String variable, String pathVarName) {
        RequestSpecification specification = testContext.getRestManager().getRequestSpecification();
        testContext.getScenarioContext().setContext(ContextKeys.REQUEST_SPEC, specification);

        String endPointUpdated =endpoint.getEndpoint().replace(String.format("{%s}", pathVarName), variable);
        Response response = specification.request(method, endPointUpdated);
        response.getBody().prettyPrint();
        testContext.getScenarioContext().setContext(ContextKeys.RESPONSE, response);
    }

    @And("^the response code is \"([^\"]*)\"$")
    public void theResponseCodeIs(Integer expectedResponseCode) {
        Response response = (Response) testContext.getScenarioContext().getContext(ContextKeys.RESPONSE);
        response.getBody().prettyPrint();

        //assertion
        response.then().statusCode(expectedResponseCode);
        String errorMessage = "Status response is %s";
        Assert.assertEquals(String.format(errorMessage, response.getStatusCode()),
                response.getStatusCode(), (int) expectedResponseCode);

    }

    @And("^the response contains \"([^\"]*)\"$")
    public void theResponseContains(String expectedString) {

    }
}
