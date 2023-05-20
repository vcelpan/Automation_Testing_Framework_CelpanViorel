package ProductsUI.opencart.stepDefinitions;

import ProductsUI.opencart.ContextManagers.TestContext;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

    private final TestContext testContext;
    private static final Logger logger = LogManager.getLogger(Hooks.class);

    public Hooks(TestContext context){
        testContext = context;
    }

    @Before
    public void setUpBeforeEach(){
        testContext.getWebDriverManager().getDriver().manage().window().maximize();
        logger.info("The test execution has been started.");
    }

    @After
    public void tearDownAfterEach(){
        testContext.getWebDriverManager().getDriver().close();
        logger.info("The test case is finished.\n");
    }
}
