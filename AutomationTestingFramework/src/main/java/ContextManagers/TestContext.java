package ContextManagers;

import managers.RestManager;
import managers.WebDriverManager;

public class TestContext {
    private final WebDriverManager webDriverManager;
    private final RestManager restManager;
    private final ScenarioContext scenarioContext;

    public TestContext(){
        webDriverManager = new WebDriverManager();
        restManager = new RestManager();
        scenarioContext = ScenarioContext.getInstance();
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public RestManager getRestManager(){
        return restManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }

}
