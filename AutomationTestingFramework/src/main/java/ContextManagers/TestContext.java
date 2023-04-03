package ContextManagers;

import managers.WebDriverManager;

public class TestContext {

    private WebDriverManager webDriverManager;
//    private ScenarioContext scenarioContext;

    public TestContext(){
        webDriverManager = new WebDriverManager("CHROME");
//        scenarioContext = ScenarionContext.getInstance();
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }
}
