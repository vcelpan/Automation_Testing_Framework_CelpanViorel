package ContextManagers;

import managers.WebDriverManager;

public class TestContext {
    private final WebDriverManager webDriverManager;
    private final ScenarioContext scenarioContext;

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
