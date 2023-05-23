package ProductsAPI.petstore;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/ProductsAPI/petstore/features",
        glue = "ProductsAPI/petstore/stepDefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = {"@api"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class TestRunnerAPI {
}
