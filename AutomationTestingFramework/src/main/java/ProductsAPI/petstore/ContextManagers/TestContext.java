package ProductsAPI.petstore.ContextManagers;

import ProductsAPI.petstore.managers.RestManager;

public class TestContext {

    private final RestManager restManager;
    private final ScenarioContext scenarioContext;

    public TestContext(){
        restManager = new RestManager();
        scenarioContext = ScenarioContext.getInstance();
    }

    public RestManager getRestManager(){
        return restManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

}
