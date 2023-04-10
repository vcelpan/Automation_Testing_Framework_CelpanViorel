package ContextManagers;

import managers.WebDriverManager;

public class TestContext {
    private WebDriverManager webDriverManager;
    private ScenarioContext scenarioContext;

    public TestContext(){
        webDriverManager = new WebDriverManager();
        scenarioContext = ScenarioContext.getInstance();
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public ScenarioContext getScenarioContext() {
        return scenarioContext;
    }
}
