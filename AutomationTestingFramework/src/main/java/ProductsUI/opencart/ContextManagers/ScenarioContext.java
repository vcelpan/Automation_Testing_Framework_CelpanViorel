package ProductsUI.opencart.ContextManagers;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static ScenarioContext instance;
    private final Map<ContextKeys, Object> scenarioContext;

    private ScenarioContext() { scenarioContext = new HashMap<>(); }

    public static ScenarioContext getInstance() {
        if (instance == null)
            instance = new ScenarioContext();
        return instance;
    }

    public void setContext(ContextKeys key, Object value){
        scenarioContext.put(key, value);
    }

    public Object getContext(ContextKeys key){
        return scenarioContext.get(key);
    }

}
